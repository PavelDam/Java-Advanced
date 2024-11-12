package _04_InterfacesAndAbstraction.Exercise.P07_CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();
        String[] input = scanner.nextLine().split("\\s+");
        int removeOperations = Integer.parseInt(scanner.nextLine());
        addOperations(input, addCollection);
        addOperations(input, addRemoveCollection);
        addOperations(input, myList);

        removeOperations(removeOperations,addRemoveCollection);
        removeOperations(removeOperations,myList);
    }

    public static void addOperations(String[] input, Addable addable) {
        for (String word : input) {
            System.out.print(addable.add(word) + " ");
        }
        System.out.println();
    }

    public static void removeOperations(int counter, AddRemovable addRemovable) {
        for (int i = 0; i < counter; i++) {
            System.out.print(addRemovable.remove()+" ");
        }
        System.out.println();
    }
}
