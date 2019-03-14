package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream sdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu =
            "Меню.\r\n" +
            "0. Добавить заявку.\r\n" +
            "1. Показать все заявки.\r\n" +
            "2. Редактировать/заменить заявку.\r\n" +
            "3. Удалить заявку.\r\n" +
            "4. Найти заявку по идентификатору.\r\n" +
            "5. Найти заявку по имени.\r\n" +
            "6. Выйти из программы.\r\n" +
            "Выбор: \r\n";

    @Before
    public void loadOutput() {
        System.out.println("Начало теста. Пользователь выбрал -");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.sdout);
        System.out.println(this.out.toString() + "Конец теста.");
        System.out.println();
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasRemovedItem() {
        Tracker tracker = new Tracker();
        //Задаём вручную несколько заявок
        Item first = tracker.add(new Item("pes", "gav"));
        Item second = tracker.add(new Item("kot", "myau"));
        Item third = tracker.add(new Item("gus", "krya"));
        //создаем StubInput с параметрами на удаление второй заявки.
        Input input = new StubInput(new String[]{"3", second.getId(), "6"});
        new StartUI(input, tracker).init();
        //проверяем индекс заявки, следующей за удаленной
        assertThat(tracker.indexOf(third.getId()), is(1));
    }

    @Test
    public void whenFindIdThenTrackerReturnItem() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("pes", "gav"));
        Item second = tracker.add(new Item("kot", "myau"));
        Item third = tracker.add(new Item("gus", "krya"));
        Input input = new StubInput(new String[]{"4", second.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(second.getId()).getName(), is("kot"));
    }

    @Test
    public void whenFindNameThenTrackerReturnItem() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("pes", "gav"));
        Item second = tracker.add(new Item("kot", "myau"));
        Item third = tracker.add(new Item("gus", "krya"));
        Input input = new StubInput(new String[]{"5", second.getName(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[] {second};
        assertThat(tracker.findByName(second.getName()), is(result));
    }

    @Test
    public void whenFindAllTrackerReturnArray() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("pes", "gav"));
        Item second = tracker.add(new Item("kot", "myau"));
        Item third = tracker.add(new Item("gus", "krya"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[] {first, second, third};
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void whenUserAddItemThenConsoleShowNewId() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(this.out.toString(), is(
                menu +
                "------------ Добавление новой заявки --------------\r\n" +
                "------------ Новая заявка с getId : " + tracker.findAll()[0].getId() + "-----------\r\n" +
                menu));
    }

    @Test
    public void whenUserUpdateItemThenConsoleShowNewItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                menu +
                        "------------ Редактировние заявки --------------\r\n" +
                        "Операция выполнена. Новая заявка имеет ID: " + tracker.findAll()[0].getId() +
                        " Имя заявки: test replace Описание заявки: заменили заявку\r\n" +
                        menu));
    }

    @Test
    public void whenDeleteThenConsoleShowSuccess() {
        Tracker tracker = new Tracker();
        //Задаём вручную несколько заявок
        Item first = tracker.add(new Item("pes", "gav"));
        Item second = tracker.add(new Item("kot", "myau"));
        Item third = tracker.add(new Item("gus", "krya"));
        //создаем StubInput с параметрами на удаление второй заявки.
        Input input = new StubInput(new String[]{"3", second.getId(), "6"});
        new StartUI(input, tracker).init();
        //проверяем индекс заявки, следующей за удаленной
        assertThat(this.out.toString(), is(
                menu +
                        "------------ Удаление заявки --------------\r\n" +
                        "------------ Операция выполнена --------------\r\n" +
                        menu));
    }

    @Test
    public void whenFindIdThenConsoleShowItem() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("pes", "gav"));
        Item second = tracker.add(new Item("kot", "myau"));
        Item third = tracker.add(new Item("gus", "krya"));
        Input input = new StubInput(new String[]{"4", second.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                menu +
                        "------------ Поиск заявки по идентификатору --------------\r\n" +
                        "------------ Найдена заявка : kot Описание: myau-----------\r\n" +
                        menu));
    }

    @Test
    public void whenFindNameThenConsoleShowItem() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("pes", "gav"));
        Item second = tracker.add(new Item("kot", "myau"));
        Item third = tracker.add(new Item("gus", "krya"));
        Input input = new StubInput(new String[]{"5", second.getName(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[]{second};
        assertThat(this.out.toString(), is(
                menu +
                        "------------ Поиск заявок по имени --------------\r\n" +
                        "ID заявки: " + tracker.findAll()[1].getId() + " Имя: kot Описание: myau\r\n" +
                        menu));
    }

    @Test
    public void whenFindAllThenConsoleShowAllItems() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("pes", "gav"));
        Item second = tracker.add(new Item("kot", "myau"));
        Item third = tracker.add(new Item("gus", "krya"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        Item[] result = new Item[] {first, second, third};
        assertThat(this.out.toString(), is(
                menu +
                        "------------ Все заполненные заявки --------------\r\n" +
                        tracker.findAll() +
                        menu));
    }
}
