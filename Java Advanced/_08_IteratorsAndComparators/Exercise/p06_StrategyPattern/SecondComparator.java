package _08_IteratorsAndComparators.Exercise.p06_StrategyPattern;

import java.util.Comparator;

public class SecondComparator implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {

        return Integer.compare(f.getAge(), s.getAge());
    }
}
