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
        int j;
        int i;
        int dublicates = 0;
        String temp;
        for (j = 0; j < array.length - dublicates; j++) {
            for (i = j + 1; i < array.length - dublicates; i++) {
                if (array[j].equals(array[i])) {
                    temp = array[array.length - 1 - dublicates];
                    array[array.length - 1 - dublicates] = array[i];
                    array[i] = temp;
                    i--;
                    dublicates++;
                }
            }
        }
        /*for (int j = 0; j < array.length - 1; j++) {
            for (i = start; i < array.length - 1; i++) {
                if (array[j].equals(array[i])) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
                if (array[j].equals(array[array.length - 1])) {
                    removeSize--;
                }
            }
            start++;
        }
        return Arrays.copyOf(array, removeSize);
        */
        return Arrays.copyOf(array, array.length - dublicates);
    }
}
