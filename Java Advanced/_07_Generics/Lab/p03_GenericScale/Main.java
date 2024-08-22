package _07_Generics.Lab.P03_GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(15,11);
        System.out.println(scale.getHeavier());


    }
}
