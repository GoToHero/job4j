package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = false;
        char[] value = prefix.toCharArray();
        int x;
        int y = 0;
        for (x = 0; x != value.length - 1; x++) {
            if (value[x] == this.data[y]) {
                result = true;
                y++;
            }
            else {
                result = false;
                break;
            }
        }
                // проверить. что массив data имеет первые элементы одинаковые с value
        return result;
    }
}