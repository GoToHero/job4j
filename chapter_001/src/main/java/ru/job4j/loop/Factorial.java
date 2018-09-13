package ru.job4j.loop;

/**
 * @author GoToHero
 * @version $Id$
 * @since 0.1
 */
public class Factorial {

    /**
     *
     * @param n Число, возводимое в факториал.
     * @return  Факториал заданного числа.
     */
    public int calc(int n) {
        int multiply = 1;
        for (int i = 1; i != n + 1; i++) {
            multiply = multiply * i;
            }
        return multiply;
    }
}

