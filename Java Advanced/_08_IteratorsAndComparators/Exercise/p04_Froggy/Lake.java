package _08_IteratorsAndComparators.Exercise.p04_Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> lake;

    public Lake(Integer... lake) {
        this.lake = List.of(lake);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Froggy();
    }

    class Froggy implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            if (index >= lake.size() && index % 2 == 0) {
                index = 1;
            }
            return index < lake.size();
        }

        @Override
        public Integer next() {

            Integer element = lake.get(index);
            index += 2;
            return element;
        }
    }
}
