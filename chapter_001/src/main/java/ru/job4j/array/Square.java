package ru.job4j.array;

/* Попытка использования for each.
public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int number:rst) {
            rst[number] = number * number;
        }
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        return rst;
    }
}
*/

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int number;
        for (number = 0; number != (bound - 1); number++) {
            rst[number] = (number + 1) * (number + 1);
        }
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        return rst;
    }
}