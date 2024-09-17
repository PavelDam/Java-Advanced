package _Exams.RetakeExam_13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Blacksmith {
    public static class Sword {
        private String name;
        private int resources;
        private int count;
        private static List<Sword> swordList = new ArrayList<>();

        public Sword(String name, int resources) {
            this.name = name;
            this.resources = resources;
            this.count = 0;
        }

        static {
            swordList.add(new Sword("Gladius", 70));
            swordList.add(new Sword("Shamshir", 80));
            swordList.add(new Sword("Katana", 90));
            swordList.add(new Sword("Sabre", 110));
        }

        public void setCount() {
            this.count = count + 1;
        }

        public static List<Sword> getSwordList() {
            return swordList;
        }

        public String getName() {
            return name;
        }

        public int getResources() {
            return resources;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return String.format("%s: %d",name,count);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(steelQueue::offer);

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(carbonStack::push);

        List<Sword> swordList = Sword.getSwordList();
        boolean atLeastOneSword = false;
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int result = steel + carbon;
            boolean findSword = false;

            for (Sword sword : swordList) {
                if (sword.getResources() == result) {
                    sword.setCount();
                    findSword = true;
                    atLeastOneSword = true;
                    break;
                }
            }
            if (!findSword) {
                carbon += 5;
                carbonStack.push(carbon);
            }

        }
        printSwordsCount(swordList, atLeastOneSword);

        printSteelQueue(steelQueue);

        printCarbonStack(carbonStack);

        swordList.stream().sorted((f,s)->f.getName().compareTo(s.getName())).filter(sword -> sword.getCount()>0).forEach(System.out::println);
    }

    private static void printCarbonStack(ArrayDeque<Integer> carbonStack) {
        if (carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        }else {
            System.out.print("Carbon left: ");
            System.out.print(
                    carbonStack.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", "))
            );
            System.out.println();
        }
    }

    private static void printSteelQueue(ArrayDeque<Integer> steelQueue) {
        if (steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        }else {
            System.out.print("Steel left: ");
            System.out.print(
                    steelQueue.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", "))
            );
            System.out.println();
        }
    }

    private static void printSwordsCount(List<Sword> swordList, boolean atLeastOneSword) {
        if (atLeastOneSword) {
            int totalSword = swordList.stream().mapToInt(Sword::getCount).sum();
            System.out.printf("You have forged %d swords.%n",totalSword);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
    }
}
