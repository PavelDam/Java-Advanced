package _02_Encapsulation.Exercise.P05_FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //        •	"Team;{TeamName}" – add a new team

        String input = scanner.nextLine();

        Map<String, Team> teamMap = new LinkedHashMap<>();
        while (!"END".equals(input)) {
            String[] inputArr = getSplitInput(input);
            String command = inputArr[0];

            try {
                switch (command) {
                    case "Team":
                        String teamName = inputArr[1];
                        Team team = new Team(teamName);
                        teamMap.put(teamName, team);
                        break;
                    case "Add":
                        addPlayer(teamMap, inputArr);
                        break;
                    case "Remove":
                        removePlayer(teamMap, inputArr);
                        break;
                    case "Rating":
                        printRating(teamMap, inputArr);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }

    private static void printRating(Map<String, Team> teamMap, String[] inputArr) {
        String teamName = inputArr[1];

        if (!teamMap.containsKey(teamName)) {
            throw new IllegalArgumentException(printMissingTeamMessage(teamName));
        }

        Team team = teamMap.get(teamName);
        System.out.printf("%s - %d%n", teamName, Math.round(team.getRating()));
    }

    private static void removePlayer(Map<String, Team> teamMap, String[] inputArr) {
        String teamName = inputArr[1];
        String playerName = inputArr[2];
        Team team = teamMap.get(teamName);
        team.removePlayer(playerName);
    }

    private static void addPlayer(Map<String, Team> teamMap, String[] inputArr) {
        String teamName = inputArr[1];

        if (!teamMap.containsKey(teamName)) {
            throw new IllegalArgumentException(printMissingTeamMessage(teamName));
        }

        String playerName = inputArr[2];
        int endurance = Integer.parseInt(inputArr[3]);
        int sprint = Integer.parseInt(inputArr[4]);
        int dribble = Integer.parseInt(inputArr[5]);
        int passing = Integer.parseInt(inputArr[6]);
        int shooting = Integer.parseInt(inputArr[7]);
        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
        teamMap.get(teamName).addPlayer(player);
    }

    private static String printMissingTeamMessage(String teamName) {
        return "Team " + teamName + " does not exist.";
    }

    private static String[] getSplitInput(String input) {
        return input.split(";");
    }
}

