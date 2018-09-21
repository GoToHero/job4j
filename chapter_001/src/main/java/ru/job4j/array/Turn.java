package ru.job4j.array;
/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class Turn {
    /**
     * Метод, возвращающий обратный массив.
     * @param array задание исходного массива.
     * @return возвращение отраженного массива.
     */
    public int[] turn(int[] array) {
        int index;
        for (index = 0; index != (array.length / 2); index++) {
           int temp = array[index];
           array[index] = array[array.length - index - 1];
           array[array.length - index - 1] = temp;
        }
        return array;
    }
}