package _07_Generics.Exercise.P08_CustomListSorter;

import _07_Generics.Exercise.P07_CustomList.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        CustomList<String> list = new CustomList<>();

        while (!input.equals("END")) {
            String[] inputArr = input.split(" ");
            String command = inputArr[0];

            switch (command) {
                case "Add":
                    String element = inputArr[1];
                    list.add(element);

                    break;
                case "Remove":
                    int index = Integer.parseInt(inputArr[1]);
                    list.remove(index);

                    break;
                case "Contains":
                    String containsElement = inputArr[1];
                    System.out.println(list.contains(containsElement));

                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(inputArr[1]);
                    int secondIndex = Integer.parseInt(inputArr[2]);
                    list.swap(firstIndex, secondIndex);

                    break;
                case "Greater":
                    String graterElement = inputArr[1];
                    long count = list.countGraterThan(graterElement);
                    System.out.println(count);

                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                case "Sort":
                    list.sorted();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
