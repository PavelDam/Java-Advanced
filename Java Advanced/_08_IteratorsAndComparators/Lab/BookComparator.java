package _08_IteratorsAndComparators.Lab;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare(Book f, Book s) {
        int result = f.getTitle().compareTo(s.getTitle());

        if (result == 0) {
            result = Integer.compare(f.getYear(), s.getYear());
        }


        return result;
    }

}
