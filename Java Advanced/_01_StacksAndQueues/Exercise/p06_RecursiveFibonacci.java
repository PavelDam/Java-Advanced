package _01_StacksAndQueues.Exercises.Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Редица на Фибоначи = 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89.....
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(fib(n));

    }

    public static long fib(int n) {
        //n = 1 -> F1 = 1
        //n = 2 -> F2 = 1
        //...
        //n = 20 -> F20 = ? = F19 + F18
        if (n < 2) {
            return 1;
        }
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);

        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();
            stack.push(num1);
            stack.push(num1 + num2);
        }

        return stack.pop();
    }
}
