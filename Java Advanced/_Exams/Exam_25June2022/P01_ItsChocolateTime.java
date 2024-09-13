package _Exams.Exam_25June2022;

import java.util.*;

public class P01_ItsChocolateTime {
    public static class Chocolate {
        private String name;
        private int count;
        private int cacaoPercentage;
        private static List<Chocolate> chocolateList = new ArrayList<>();

        public Chocolate(String name, int cacaoPercentage) {
            this.name = name;
            this.count = 0;
            this.cacaoPercentage = cacaoPercentage;
        }

        public static void add() {
            Chocolate chocolate = new Chocolate("Milk Chocolate", 30);
            chocolateList.add(chocolate);
            chocolate = new Chocolate("Dark Chocolate", 50);
            chocolateList.add(chocolate);
            chocolate = new Chocolate("Baking Chocolate", 100);
            chocolateList.add(chocolate);
        }

        public void setCount() {
            this.count += 1;
        }

        public String getName() {
            return name;
        }

        public int getCacaoPercentage() {
            return cacaoPercentage;
        }

        public int getCount() {
            return count;
        }

        public static List<Chocolate> getList() {
            return chocolateList;
        }

        @Override
        public String toString() {
            return String.format("# %s --> %d%n", name, count);
        }
    }

    public static void main(String[] args) {
        Chocolate.add();
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> queueMilk = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).forEach(queueMilk::offer);

        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).forEach(cacaoStack::push);

        List<Chocolate> list = Chocolate.getList();

        while (!queueMilk.isEmpty() && !cacaoStack.isEmpty()) {
            double milk = queueMilk.poll();
            double cacao = cacaoStack.pop();
            double percentage = cacao / (cacao + milk) * 100;

            boolean makeChocolate = false;

            for (Chocolate chocolate : list) {
                if (chocolate.getCacaoPercentage() == percentage) {
                    chocolate.setCount();
                    makeChocolate = true;
                    break;
                }
            }
            if (!makeChocolate) {
                milk += 10;
                queueMilk.offer(milk);
            }
        }

        boolean allChocolates = list.stream().allMatch(chocolate -> chocolate.getCount() > 0);

        System.out.println(allChocolates
                ? "It’s a Chocolate Time. All chocolate types are prepared."
                : "Sorry, but you didn't succeed to prepare all types of chocolates.");

        list.stream().sorted((f, s) -> f.getName().compareTo(s.getName())).filter(chocolate -> chocolate.getCount() > 0).forEach(System.out::print);
    }
}
