package _Exams.Exam_28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Bombs {
    public static class Bomb {
        private String name;
        private int size;
        private int count;

        private static List<Bomb> bombList = new ArrayList<>();

        static {
            bombList.add(new Bomb("Datura Bombs", 40));
            bombList.add(new Bomb("Cherry Bombs", 60));
            bombList.add(new Bomb("Smoke Decoy Bombs", 120));
        }

        public Bomb(String name, int size) {
            this.name = name;
            this.size = size;
            this.count = 0;
        }

        public static List<Bomb> getBombList() {
            return bombList;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(bombEffectsQueue::offer);

        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(bombCasingsStack::push);

        List<Bomb> bombList = Bomb.getBombList();

        boolean bombPouch = false;

        while (!bombEffectsQueue.isEmpty() && !bombCasingsStack.isEmpty() && !bombPouch) {
            int bombEffect = bombEffectsQueue.peek();
            int bombCasing = bombCasingsStack.pop();
            int currentSum = bombEffect + bombCasing;
            boolean findBomb = false;

            for (Bomb bomb : bombList) {
                if (bomb.getSize() == currentSum) {
                    bombEffectsQueue.poll();
                    bomb.setCount(bomb.getCount() + 1);
                    findBomb = true;
                    break;
                }
            }
            if (!findBomb) {
                bombCasing -= 5;
                bombCasingsStack.push(bombCasing);
            }
            bombPouch = checkPouch(bombList);
        }
        System.out.println(bombPouch
                ? "Bene! You have successfully filled the bomb pouch!"
                : "You don't have enough materials to fill the bomb pouch.");
        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.print(
                    bombEffectsQueue.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", "))
            );
            System.out.println();
        }
        if (bombCasingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.print(
                    bombCasingsStack.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", "))
            );
            System.out.println();
        }
        bombList.stream().sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(bomb -> System.out.printf("%s: %d%n", bomb.getName(), bomb.getCount()));
    }

    private static boolean checkPouch(List<Bomb> bombList) {
        return bombList.stream().allMatch(bomb -> bomb.getCount() >= 3);
    }
}