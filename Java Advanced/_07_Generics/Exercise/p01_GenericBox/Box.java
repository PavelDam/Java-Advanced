package _07_Generics.Exercise.P01_GenericBox;

public class Box<T> {
    private T input;

    public Box(T input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n",input.getClass().getName(),input);
    }

}
