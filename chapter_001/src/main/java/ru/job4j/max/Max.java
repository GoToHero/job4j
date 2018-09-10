package ru.job4j.max;

/**
 * @author GoToHero
 * @version $Id$
 * @since 0.1
 */

//Тоже рабочий вариант, тесты проходят.
/*public class Max {
    /**
     *
     * @param first Первое число.
     * @param second Второе число.
     * @return Возврат максимального значения.
     */
/*    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return this.max(temp, third);
    }
}*/

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

    /**
     *
     * @param first Первое число.
     * @param second Второе число.
     * @param third Третье число.
     * @return Возврат максимального значения.
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
        }
}