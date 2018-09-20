package ru.job4j.array;
/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class FindLoop {
    /**
     * Метод для поиска заданного значения в массиве целых чисел.
     * @param data задание массива.
     * @param el задание искомого значения.
     * @return вывод номера элемента массива, при совпадении.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        int index;
        for (index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}