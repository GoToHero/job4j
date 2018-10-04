package ru.job4j.array;

import java.util.Arrays;

/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class ArrayDublicate {
    /**
     * Удаление дубликатов в массиве.
     * @param array исходный массив.
     * @return сокращенный массив.
     */
    public String[] remove(String[] array) {
        String temp;
        int start = 0;
        int i;
        for (int j = 0; j < array.length - 1; j++) {
            for (i = start; i < array.length - 1; i++) {
                if (array[j].equals(array[i])) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            start++;
        }
        return Arrays.copyOf(array, 5);
    }
}
