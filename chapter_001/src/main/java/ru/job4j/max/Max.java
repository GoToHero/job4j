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
     * @return Возврат максимального значения.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return this.max(temp, third);
    }
}