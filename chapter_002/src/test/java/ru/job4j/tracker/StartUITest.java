package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
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
}
