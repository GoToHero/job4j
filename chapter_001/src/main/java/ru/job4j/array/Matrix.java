package ru.job4j.array;
/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class Matrix {
    /**
     * Построение таблицы умножения в виде двумерного массива.
     * @param size размер таблицы
     * @return массив значений таблицы.
     */
    public int[][] multiple(int size) {
        int i;
        int j;
        int[][] result = new int[size][size];
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                result[i][j] = (i + 1) * (j + 1);
            }
        }
        return result;
    }
}