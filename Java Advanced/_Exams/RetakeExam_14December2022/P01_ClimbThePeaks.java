package _Exams.RetakeExam_14December2022;

import java.util.*;

public class P01_ClimbThePeaks {
    public static class Peak {
        private String name;
        private int difficulty;
        private boolean conquered;
        private static List<Peak> data = new ArrayList<>();

        public Peak(String name, int difficulty) {
            this.name = name;
            this.difficulty = difficulty;
            this.conquered = false;
        }

        static {
            data.add(new Peak("Vihren", 80));
            data.add(new Peak("Kutelo", 90));
            data.add(new Peak("Banski Suhodol", 100));
            data.add(new Peak("Polezhan", 60));
            data.add(new Peak("Kamenitza", 70));
        }

        public void setConquered() {
            this.conquered = true;
        }

        public String getName() {
            return name;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public boolean isConquered() {
            return conquered;
        }

        public static List<Peak> getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Peak> data = Peak.getData();

        ArrayDeque<Integer> dailyFoodPortionsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(dailyFoodPortionsStack::push);

        ArrayDeque<Integer> dailyStaminaQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(dailyStaminaQueue::offer);

        int daysOfAdventure = 7;
        boolean climbedAllPeaks = false;
        int day = 1;

        while (day <= daysOfAdventure && !climbedAllPeaks) {
            int food = dailyFoodPortionsStack.pop();
            int stamina = dailyStaminaQueue.poll();
            int sum = food + stamina;

            for (Peak peak : data) {
                if (peak.getDifficulty() <= sum && !peak.isConquered()) {
                    peak.setConquered();
                    break;
                }
            }
            climbedAllPeaks = checkClimbedPeaks(data);
            day++;
        }

        if (climbedAllPeaks) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            printPeaks(data);
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
    }

    private static void printPeaks(List<Peak> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("Conquered peaks:").append(System.lineSeparator());
        data.forEach(p -> sb.append(p.getName()).append(System.lineSeparator()));
        System.out.println(sb.toString().trim());

    }

    private static boolean checkClimbedPeaks(List<Peak> data) {
        return data.stream().allMatch(Peak::isConquered);
    }
}
