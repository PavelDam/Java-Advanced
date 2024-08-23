package _07_Generics.Exercise.P07_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable> {

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(list, firstIndex, secondIndex);
    }

    public long countGraterThan(T element) {
        return list.stream()
                .filter(t -> element.compareTo(t) < 0)
                .count();
    }

    public T getMin() {
        return list.stream().min(Comparable::compareTo).orElseThrow(IllegalArgumentException::new);
    }

    public T getMax() {
        return list.stream().max(Comparable::compareTo).orElseThrow(IllegalArgumentException::new);
    }

    public void print() {
        list.forEach(System.out::println);
    }

    public void sorted() {
        list = list.stream().sorted().collect(Collectors.toList());
    }
}
