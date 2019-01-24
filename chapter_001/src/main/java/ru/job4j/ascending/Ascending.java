package ru.job4j.ascending;
/**
 *Sort ascending programm.
 *@author GoToHero
 *@since 16.01.19
 *@version 1.0
 */
public class Ascending {
    /**
     * Метод сортирующий два массива отсортированные по возрастанию в один массив отсортированный по возрастанию.
     * @param firstArray первый массив отстортированный по возрастанию.
     * @param secondArray второй массив отстортированный по возрастанию.
     * @return суммарный массив отстортированный по возрастанию.
     */
    public static int[] increasingSort(int[] firstArray, int[] secondArray) {
        int n = firstArray.length;
        int m = secondArray.length;
        int[] increasArray = new int[n + m];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < n && j < m) {
            if (firstArray[i] < secondArray[j]) {
                increasArray[index] = firstArray[i];
                i++;
            } else {
                increasArray[index] = secondArray[j];
                j++;
            }
            index++;
        }
        while (i < n) {
            increasArray[index] = firstArray[i];
            index++;
            i++;
        }
        while (j < m) {
            increasArray[index] = secondArray[j];
            index++;
            j++;
        }
        return increasArray;
    }
}