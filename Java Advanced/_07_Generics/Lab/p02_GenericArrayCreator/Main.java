package _07_Generics.Lab.P02_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.create(10, 2);

        for (Integer integer : arr) {
            System.out.print(integer+" ");
        }
    }
}
