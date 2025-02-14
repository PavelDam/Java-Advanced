package _exercise.p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {3, 69, 10};
    private Database database;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreateDatabase() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        assertArrayEquals(NUMBERS, dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] bigArray = new Integer[17];
        new Database(bigArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithLessThan1Element() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        new Database(emptyArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddElement() throws OperationNotSupportedException {
        database.add(7);
        Integer[] dbElements = database.getElements();
        int addedElement = dbElements[dbElements.length - 1];
        assertEquals(7, addedElement);
        assertEquals(dbElements.length, NUMBERS.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementOutOfBoundShouldThrow() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();

        for (int i = 0; i < dbElements.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveElement() throws OperationNotSupportedException {
        Integer[] elementsBeforeRemove = database.getElements();
        database.remove();
        Integer[] elementsAfterRemove = database.getElements();

        int lengthAfterRemoveElement = elementsAfterRemove.length;
        int lengthBeforeRemoveElement = elementsBeforeRemove.length - 1;
        assertEquals(lengthAfterRemoveElement, lengthBeforeRemoveElement);

        int lestElementAfterRemove = elementsAfterRemove[elementsAfterRemove.length - 1];
        int secondLastElementBeforeRemove = elementsBeforeRemove[elementsBeforeRemove.length - 2];
        assertEquals(lestElementAfterRemove, secondLastElementBeforeRemove);

    }
}