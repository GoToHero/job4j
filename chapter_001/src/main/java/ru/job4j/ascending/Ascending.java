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
        int x;
        int y;
        int arraySize = firstArray.length + secondArray.length;
        int[] increasArray = new int [arraySize];
        for (x = 0; x < firstArray.length; x++) {
            for (y = 0; y < secondArray.length; y++) {
                if (secondArray[x] <= firstArray[y]) {
                    increasArray[step] = secondArray[x];
                    increasArray[step + 1] = ;
                }

            }
        }
        return increasArray;
    }
}