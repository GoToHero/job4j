package ru.job4j.ascending;
/**
 *Sort ascending programm.
 *@author GoToHero
 *@since 16.01.19
 *@version 1.0
 */
public class Ascending {
    private static int[] firstArray;
    private static int[] secondArray;

    public static int[] increasingSort (int[] firstArray, int[] secondArray) {
        int n = firstArray.length;
        int m = secondArray.length;
        int[] increasArray = new int [n + m];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < n && j < m) {
            if (firstArray[i] < secondArray[j]) {
                increasArray[index] = firstArray[i];
                i++;
            }
            else {
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
        /*for (i, j; i < n && j < m; index++) {
            if (firstArray[i] < secondArray[j]) {
                increasArray[index] = firstArray[i];
                i++;
            }
            else {
                increasArray[index] = secondArray[j];
                j++;
            }
        }
        for (i; i < n; index++) {
            increasArray[index] = firstArray[i];
            i++;
        }
        for (j; j < m; index++) {
            increasArray[index] = secondArray[j];
            j++;
        }*/
        return increasArray;
    }
}