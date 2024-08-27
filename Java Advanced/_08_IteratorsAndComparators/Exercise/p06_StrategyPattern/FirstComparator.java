package _08_IteratorsAndComparators.Exercise.p06_StrategyPattern;

import java.util.Comparator;

public class FirstComparator implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        int result = Integer.compare(f.getName().length(), s.getName().length());
        if (result == 0) {
            result = Character.compare(f.getName().toUpperCase().charAt(0), s.getName().toUpperCase().charAt(0));
        }
        return result;
    }
}
