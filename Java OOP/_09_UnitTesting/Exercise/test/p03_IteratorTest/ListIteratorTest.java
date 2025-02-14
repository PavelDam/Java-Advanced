package _exercise.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static final String[] NAMES = {"pav", "di", "bibi"};

    private ListIterator listIterator;

    @Before
    public void prepare() throws OperationNotSupportedException {
       listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithNullElement() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testConstructorShouldCreate() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test
    public void testHasNext() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected =  IllegalStateException.class)
    public void testPrintWithNoElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrint() {
        String pav = listIterator.print();
        assertEquals(NAMES[0], pav);
    }
}