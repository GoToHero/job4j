package ru.job4j.loop;

/**
 * @author GoToHero
 * @version $Id$
 * @since 0.1
 */
public class Counter{
    /**
     * Метод принимающий два целых числа и возвращающий сумму диапазона четных чисел
     * @param start первое число
     * @param finish второе число
     * @return сумма диапазона
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}