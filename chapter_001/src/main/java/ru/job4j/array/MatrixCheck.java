package ru.job4j.array;
/**
 *  @author GoToHero
 *  @version $Id$
 *  @since 0.1
 */
public class MatrixCheck {
    /**
     * Метод проверяющий диагонали массива на истинность.
     * @param data исходный массив.
     * @return значение истинности однородности диагоналей.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;

            for (int i = 1; i < data.length - 1; i++) {
                if (data[0][0] != data[i][i]) {
                    result = false;
                    break;
                }
                if (data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}
