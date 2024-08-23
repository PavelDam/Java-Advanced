package _07_Generics.Exercise.P04_GenericSwapMethodInteger;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Generic<Integer>list = new Generic<>();

        for (int i = 0; i < count; i++) {
            list.addElement(Integer.parseInt(scanner.nextLine()));
        }
        String indexes = scanner.nextLine();
        int firstIndex = Integer.parseInt(indexes.split(" ")[0]);
        int secondIndex = Integer.parseInt(indexes.split(" ")[1]);

        list.swap(firstIndex,secondIndex);

        list.print();
    }
}
