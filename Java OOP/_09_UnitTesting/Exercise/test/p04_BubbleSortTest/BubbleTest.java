package _exercise.p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] numbers = {3, 5, 2, 10, -5, 0};
        int [] sorted = {-5, 0, 2, 3, 5, 10};
        Bubble.sort(numbers);
        assertArrayEquals(sorted, numbers);
    }
}