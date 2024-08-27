package _08_IteratorsAndComparators.Exercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> names;
    private int index;

    public ListyIterator(String... names) {
        this.names = List.of(names);
        this.index = 0;
    }


    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < names.size() - 1;
    }

    public void print() {
        try {
            System.out.println(names.get(index));
        } catch (Exception e) {
            System.out.println("Invalid Operation!");
        }
    }

    public void printAll() {
        String result = String.join(" ", names);
        System.out.printf("%s%n", result);
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < names.size() - 1;
            }

            @Override
            public String next() {
                String element = names.get(index);
                index++;
                return element;
            }
        };
    }
}
