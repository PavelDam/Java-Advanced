package _01_StacksAndQueues.Lab.Stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimal==0){

            System.out.println(0);
        }else{
            while (decimal != 0) {
                stack.push(decimal % 2);
                decimal /= 2;

            }
            for (Integer integer : stack) {
                System.out.print(integer);
            }
        }

    }
}
