package _exercise.p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> list;

    @Before
    public void prepare() {
        list = new CustomLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementFromIndexLessThan0ShouldThrow() {
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementFromIndexBiggerThanLengthShouldThrow() {
        list.get(3);
    }

    @Test
    public void testGetElementFromList() {
        int number = list.get(1);
        assertEquals(2, number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementToIndexLessThan0ShouldThrow() {
        list.set(-1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementToIndexBiggerThanLengthShouldThrow() {
        list.set(4, 4);
    }

    @Test
    public void testSetElementIntoList() {
        list.set(2, 4);
        int addedNumber = list.get(2);
        assertEquals(4, addedNumber);
    }

    @Test
    public void testAddElementAtTheEndOfTheList() {
        list.add(4);
        int addedNumber = list.get(3);
        assertEquals(4, addedNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtElementAtIndexLessThan0ShouldThrow(){
        list.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtElementAtIndexBiggerThanLengthShouldThrow(){
        list.removeAt(3);
    }

    @Test
    public void testRemoveAtShouldReturnElement() {
        int removedNumber = list.removeAt(0);
        assertEquals(1, removedNumber);
    }

    @Test
    public void testRemoveElementWhichIsNotInTheList() {
        int removedNumber = list.remove(4);
        assertEquals(-1, removedNumber);
    }

    @Test
    public void testRemoveValidElement() {
        int returnIndexOfTheRemovedNumber = list.remove(2);
        int expectedIndex = 1;
        assertEquals(expectedIndex, returnIndexOfTheRemovedNumber);
    }

    @Test
    public void testIndexOfWithInvalidElementShouldReturnInvalidIndex() {
        int invalidIndex = list.indexOf(4);
        int expectedIndex = -1;
        assertEquals(expectedIndex, invalidIndex);
    }

    @Test
    public void testIndexOfWithValidElementShouldReturnValidIndex() {
        int index = list.indexOf(1);
        int expectedIndex = 0;
        assertEquals(expectedIndex, index);
    }

    @Test
    public void testContainsWithValidElementShouldReturnTrue() {
        boolean isValid = list.contains(1);
        assertTrue(isValid);
    }

    @Test
    public void testContainsWithInvalidElementShouldReturnFalse() {
        boolean isValid = list.contains(4);
        assertFalse(isValid);
    }
}