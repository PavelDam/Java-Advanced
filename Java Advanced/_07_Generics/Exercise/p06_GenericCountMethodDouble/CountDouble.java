package _07_Generics.Exercise.P06_GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class CountDouble<T extends Comparable> {

    private List<T> list;

    public CountDouble() {
        this.list = new ArrayList<>();
    }
    public void addElement(T element) {

        list.add(element);
    }

    public long count(T element) {
        return list.stream()
                .filter(t -> element.compareTo(t) < 0)
                .count();
    }
}
