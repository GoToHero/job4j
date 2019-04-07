package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для замены заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска по id.
     */
    private static final String FINDID = "4";

    /**
     * Константа меню для поиска по имени.
     */
    private static final String FINDNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Поле выключения программы.
     */
    private boolean working = true;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        int[] range = menu.getRange();
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (this.working);
    }

    /**
     * Метод завершающий программу.
     */
    public void stop() {
        this.working = false;
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showItem() {
        System.out.println("------------ Все заполненные заявки --------------");
        Item[] result = this.tracker.findAll();
        for (int index = 0; index < result.length; index++) {
            if (result[index] != null) {
                System.out.println(result[index]);
            }
        }
    }

    private void editItem() {
        System.out.println("------------ Редактировние заявки --------------");
        String id = this.input.ask("Введите ID редактируемой/заменяемой заявки :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Операция выполнена. Новая заявка имеет ID: " + item.getId() + " Имя заявки: "
                    + item.getName() + " Описание заявки: " + item.getDescription());
        } else {
            System.out.println("Операция не выполнена. С указанным ID совпадений не найдено.");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID удаляемой заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Операция выполнена --------------");
        } else {
            System.out.println("Операция не выполнена. С указанным ID совпадений не найдено.");
        }
    }

    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по идентификатору --------------");
        String id = this.input.ask("Введите ID для поиска заявки :");
        Item result = this.tracker.findById(id);
        if (result != null) {
            System.out.println("------------ Найдена заявка : " + result.getName() + " Описание: "
                    + result.getDescription() + "-----------");
        } else {
            System.out.println("Операция не выполнена. С указанным ID совпадений не найдено.");
        }
    }

    private void findByNameItem() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String key = this.input.ask("Введите имя заявки для поиска: ");
        Item[] result = this.tracker.findByName(key);
        for (int index = 0; index < result.length; index++) {
            if (result[index] != null) {
                System.out.println("ID заявки: " + result[index].getId() + " Имя: " + result[index].getName()
                        + " Описание: " + result[index].getDescription());
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить заявку.");
        System.out.println("1. Показать все заявки.");
        System.out.println("2. Редактировать/заменить заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по идентификатору.");
        System.out.println("5. Найти заявку по имени.");
        System.out.println("6. Выйти из программы.");
        System.out.println("Выбор: ");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}
