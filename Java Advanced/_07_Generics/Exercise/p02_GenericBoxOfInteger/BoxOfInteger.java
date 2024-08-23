package _07_Generics.Exercise.P02_GenericBoxOfInteger;

public class BoxOfInteger<T> {
    private T input;

    public BoxOfInteger(T input) {
        this.input = input;
    }

    @Override
    public String toString(){
        return String.format("%s: %s%n",input.getClass().getName(),input);
    }
}
