package _08_IteratorsAndComparators.Lab;

import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {

    private class LibIterator implements Iterator<Book> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }

    private Book[] books;


    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
