package ru.job4j.ascending;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AscendingTest {
    @Test
    public void whenWeHaveTwoNonIntersectingArrays() {
        Ascending ascending = new Ascending();
        int[] firstArray = new int[] {1, 2, 3, 4, 5};
        int[] secondArray = new int[] {6, 7, 8, 9, 10};
        int[] result = Ascending.increasingSort(firstArray, secondArray);
        int[] expect = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void whenWeHaveTwoDifferentSizeArrays() {
        Ascending ascending = new Ascending();
        int[] firstArray = new int[] {1, 2, 3};
        int[] secondArray = new int[] {4, 5, 6, 7, 8, 9, 10};
        int[] result = Ascending.increasingSort(firstArray, secondArray);
        int[] expect = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void whenWeHaveTwoIntersectingArrays() {
        Ascending ascending = new Ascending();
        int[] firstArray = new int[] {1, 2, 3, 4, 5};
        int[] secondArray = new int[] {3, 4, 5, 6, 7};
        int[] result = Ascending.increasingSort(firstArray, secondArray);
        int[] expect = new int [] {1, 2, 3, 3, 4, 4, 5, 5, 6, 7};
        assertThat(result, is(expect));
    }
}