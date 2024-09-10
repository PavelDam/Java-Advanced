package _Exams.Exam_22Feb2020.P03Guild.guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> playersList;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.playersList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (playersList.size() < capacity) {
            playersList.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : playersList) {
            if (player.getName().equals(name)) {
                playersList.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : playersList) {
            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : playersList) {
            if (player.getName().equals(name) && !player.getRank().equals("Trail")) {
                player.setRank("Trail");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayersList = new ArrayList<>();
        for (Player player : playersList) {
            if (player.getClazz().equals(clazz)) {
                removedPlayersList.add(player);
            }
        }
        playersList.removeAll(removedPlayersList);
        return removedPlayersList.toArray(new Player[0]);
    }

    public int count() {
        return playersList.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Player in the guild: %s:%n", name));
        for (Player player : playersList) {
            builder.append(player).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
