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
     * @param id
     * @param item
     * @return подтверждение замены.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        this.items[this.position] = findById(id);
        if (this.items[this.position] != null) {
            result = true;
        }
        return result;
    }

    /**
     * Метод удаляющий заявку.
     * @param id
     * @return подтверждение удаления.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != this.items.length; index++) {
            if (this.items[index] != null && this.items[index].equals(findById(id))) {
                this.position--;
                this.items[index] = this.items[index + 1];
                result = true;
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
        Item[] temp = new Item[this.items.length];
        int count = 0;
        for (Item item : this.items) {
            if (item != null) {
                temp[count] = item;
                count++;
            }
        }
        /*for (this.position = 0; this.position < this.items.length - 1; this.position++) {
            if (this.items[position] != null) {
                temp[count] = this.items[position];
                count++;
            }
        }*/
        return Arrays.copyOf(temp, count);
    }

    /**
     * Метод проверяющий массив заявок на совпадение по веденному слову.
     * @param key ключевое слово.
     * @return совпадающий массив заявок.
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[this.items.length];
        int count = 0;
        for (Item item : this.items) {
            if (item.getName().equals(key) ) {
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

}