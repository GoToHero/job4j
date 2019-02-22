package ru.job4j.tracker;

import java.util.*;
/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Генерация случайного числа.
     */
    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод заменяющий ячейку в массиве заявок.
     * @param id номер заявки заменяемой ячейки.
     * @param item массив на замену.
     * @return подтверждение замены.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                this.items[index] = item;
                this.items[index].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляющий заявку.
     * @param id индентификатор удаляемой заявки.
     * @return подтверждение удаления.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                result = true;
                this.position--;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращающий копию всех заполненных заявок.
     * @return копия заполненного массива.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
        /*Item[] temp = new Item[this.items.length];
        int count = 0;
        for (Item item : this.items) {
            if (item != null) {
                temp[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(temp, count);*/
    }

    /**
     * Метод проверяющий массив заявок на совпадение по веденному слову.
     * @param key ключевое слово.
     * @return совпадающий массив заявок.
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[this.position];
        int count = 0;
        /*for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getName().equals(key)) {
                temp[count] = this.items[index];
                count++;
            }
        }*/
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                temp[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    /**
     * Метод возвращающий заявку по идентификатору.
     * @param id индентификатор - ключ.
     * @return найденная заявка.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращающий index заявки по номеру заявки.
     * @param id идентификационный номер заявки.
     * @return найденный индекс массива.
     */
    public int indexOf(String id) {
        int result = -1;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

}