package _Exams.Exam_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasksStack::push);

        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(threadsQueue::offer);

        int valueOfTheTask = Integer.parseInt(scanner.nextLine());



        while (true) {
            int task = tasksStack.peek();
            int thread = threadsQueue.peek();
            if (task == valueOfTheTask) {
                System.out.printf("Thread with value %d killed task %d%n",thread,task);
                break;
            }
            if (thread >= task) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }
        }
        for (Integer integer : threadsQueue) {
            System.out.print(integer+" ");
        }
    }
}
