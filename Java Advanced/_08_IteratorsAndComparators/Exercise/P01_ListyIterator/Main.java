package _08_IteratorsAndComparators.Exercise.P01_ListyIterator;

import _08_IteratorsAndComparators.Exercise.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ListyIterator listyIterator = null;

        while (!input.equals("END")) {
            String[] inputArr = input.split(" ");
            String command = inputArr[0];

            switch (command) {
                case "Create":
                    if (inputArr.length > 1) {
                        String[] namesArr = Arrays.copyOfRange(inputArr, 1, inputArr.length);
                        listyIterator = new ListyIterator(namesArr);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
            }


            input = scanner.nextLine();
        }
    }
}
