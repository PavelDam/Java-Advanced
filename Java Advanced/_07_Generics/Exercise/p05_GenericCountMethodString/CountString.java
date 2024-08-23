package _07_Generics.Exercise.P05_GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class CountString<T extends Comparable<T>> {

    private List<T> list;

    public CountString() {
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
