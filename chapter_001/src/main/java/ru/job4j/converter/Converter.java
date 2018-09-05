package ru.job4j.converter;

/**
 * Конвертер валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 79;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары.
     */
    public int rubleToDollar(int value) {
        return value / 68;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value Евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value * 79;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value Доллар.
     * @return рубли.
     */
    public int dollarToRuble(int value) {
        return value * 68;
    }
}