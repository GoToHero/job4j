package ru.job4j.array;
/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class Check {
    /**
     * Метод проверяющий массив на одинаковые значения истинности.
     * @param data проверяемый массив.
     * @return результат, показывающий все ли значения массива истинны или ложны.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        int index;

        for (index = 0; index != data.length - 1; index++) {
            if (data[1] == data[index]) {
                result = true;
            }
            else {
                result = false;
                break;
            }
        }
        return result;
    }

    /*
    Сложный способ.
    public boolean mono(boolean[] data) {
        boolean result = false;
        int index;
        boolean boolTrue = true;
        boolean boolFalse = false;
        for (index = 0; index != data.length - 1; index++) {
        boolTrue = boolTrue & data[index];
        boolFalse = boolFalse | data[index];
        }
        if (boolTrue == true) {
            result = true;
        }
        if (boolFalse == false) {
            result = true;
        }
        return result;
    }*/
}