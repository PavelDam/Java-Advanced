package _08_IteratorsAndComparators.Lab.p03_ComparableBook;

import _08_IteratorsAndComparators.Lab.Book;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        if (bookOne.compareTo(bookTwo) > 0) {
            System.out.printf("%s is before %s%n", bookOne, bookTwo);
        } else if (bookOne.compareTo(bookTwo) < 0) {
            System.out.printf("%s is before %s%n", bookTwo, bookOne);
        } else {
            System.out.println("Book are equal");
        }
    }

}
