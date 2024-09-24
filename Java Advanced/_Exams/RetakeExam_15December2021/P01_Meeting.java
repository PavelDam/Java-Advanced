package _Exams.RetakeExam_15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(malesStack::push);

        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(femalesQueue::offer);
        int matches = 0;
        while (!femalesQueue.isEmpty() && !malesStack.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male < 1) {
                malesStack.pop();

            } else if (female < 1) {
                femalesQueue.poll();

            } else if (male % 25 == 0 || female % 25 == 0) {
                if (male % 25 == 0) {
                    malesStack.pop();
                    malesStack.pop();
                } else {
                    femalesQueue.poll();
                    femalesQueue.poll();
                }
            } else {
                if (male == female) {
                    malesStack.pop();
                    femalesQueue.poll();
                    matches++;
                } else {
                    male -= 2;
                    femalesQueue.poll();
                    malesStack.pop();
                    malesStack.push(male);
                }
            }

        }
        System.out.printf("Matches: %d%n", matches);
        System.out.println(malesStack.isEmpty()
                ? "Males left: none"
                : String.format("Males left: %s", getPeoples(malesStack)));
        System.out.println(femalesQueue.isEmpty()
                ? "Females left: none"
                : String.format("Females left: %s", getPeoples(femalesQueue)));

    }

    private static String getPeoples(ArrayDeque<Integer> data) {

        return data.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
