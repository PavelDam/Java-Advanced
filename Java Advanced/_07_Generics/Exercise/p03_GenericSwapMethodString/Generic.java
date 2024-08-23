package _07_Generics.Exercise.P03_GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generic<T> {
    private List<T> list;

    public void addElement(T element) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(list, firstIndex, secondIndex);
    }

//    public List<T> swapIndexes(int firstIndex, int secondIndex) {
//        T first = list.get(firstIndex);
//        T second = list.get(secondIndex);
//
//
//        list.set(firstIndex, second);
//        list.set(secondIndex, first);
//        return list;
//    }

    public void print() {
        list.forEach(e -> System.out.printf("%s: %s%n", e.getClass().getName(), e));
    }


}
