package ru.job4j.array;
/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class BubbleSort {
    /**
     * Сортировка массива целых чисел.
     * @param array исходный массив.
     * @return сортированный массив.
     */
    public static int[] sort(int[] array) {
        int temp;
        for (int lvl = 1; lvl < array.length; lvl++) {
            for (int index = 1; index < array.length; index++) {
                if (array[index - 1] > array[index]) {
                    temp = array[index - 1];
                    array[index - 1] = array[index];
                    array[index] = temp;
                }
            }
        }
    return array;
    }
}

//Если что попробовать вариант с занесением условия когда последнее число больше первого в цикл.