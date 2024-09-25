package _Exams.RetakeExam_17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class P01_SantaPresent {
    private static final String DOLL = "Doll";
    private static final int DOLL_MAGIC_NEEDED = 150;
    private static final String WOODEN_TRAIN = "Wooden train";
    private static final int WOODEN_TRAIN_MAGIC_NEEDED = 250;
    private static final String TEDDY_BEAR = "Teddy bear";
    private static final int TEDDY_BEAR_MAGIC_NEEDED = 300;
    private static final String BICYCLE = "Bicycle";
    private static final int BICYCLE_MAGIC_NEEDED = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new TreeMap<>();
        map.put(DOLL, 0);
        map.put(WOODEN_TRAIN, 0);
        map.put(TEDDY_BEAR, 0);
        map.put(BICYCLE, 0);

        ArrayDeque<Integer> boxesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(boxesStack::push);

        ArrayDeque<Integer> magicLevelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magicLevelsQueue::offer);


        while (!boxesStack.isEmpty() && !magicLevelsQueue.isEmpty()) {
            int box = boxesStack.peek();
            int magic = magicLevelsQueue.peek();
            int sum = box * magic;

            if (box == 0 || magic == 0) {
                if (box == 0) {
                    boxesStack.pop();
                }
                if (magic == 0) {
                    magicLevelsQueue.poll();
                }
                continue;
            }
            magicLevelsQueue.poll();
            boxesStack.pop();
            String present = "";

            if (sum < 0) {
                boxesStack.push(box + magic);
            } else if (sum > 0) {
                if (sum == DOLL_MAGIC_NEEDED) {
                    present = DOLL;
                } else if (sum == WOODEN_TRAIN_MAGIC_NEEDED) {

                    present = WOODEN_TRAIN;
                } else if (sum == TEDDY_BEAR_MAGIC_NEEDED) {
                    present = TEDDY_BEAR;
                } else if (sum == BICYCLE_MAGIC_NEEDED) {
                    present = BICYCLE;
                } else {
                    box += 15;
                    boxesStack.push(box);
                }
                if (present.length() > 0) {
                    map.put(present, map.get(present) + 1);
                }
            }
        }

        boolean craftAllPresents = (map.get(DOLL) > 0 && map.get(WOODEN_TRAIN) > 0) || (map.get(TEDDY_BEAR) > 0 && map.get(BICYCLE) > 0);

        System.out.println(craftAllPresents
                ? "The presents are crafted! Merry Christmas!"
                : "No presents this Christmas!");

        if (!boxesStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(boxesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!magicLevelsQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magicLevelsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    }
}