package ru.job4j.max;

/**
 * @author GoToHero
 * @version $Id$
 * @since 0.1
 */

public class Max {
    /**
     *
     * @param first Первое число.
     * @param second Второе число.
     * @return Возврат максимального значения из двух чисел.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}