package ru.job4j.array;

/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class Square {
    /**
     * Метод, возращающий массив, со значениями, возведенными в квадрат.
     * @param bound размер массива
     * @return массив с возведенными в квадрат значениями от 1 до "х".
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int number;
        for (number = 0; number < rst.length; number++) {
            rst[number] = (number + 1) * (number + 1);
        }
        return rst;
    }
}