package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindIDThenReturnIndex() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription1", 12L);
        tracker.add(previous);
        Item check = new Item("testForDelete", "testForDelete", 123L);
        tracker.add(check);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(next);
        assertThat(tracker.indexOf(check.getId()), is(1));
    }

    @Test
    public void whenRightIdThenReturnIndex() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription1", 12L);
        Item forDelete = new Item("testForDelete", "testForDelete", 123L);
        tracker.add(previous);
        tracker.add(forDelete);
        final int byId = tracker.indexOf(forDelete.getId());
        assertThat(byId, is(1));
    }

    @Test
    public void whenWrongIdThenNoIndex() {
        Tracker tracker = new Tracker();
        Item forDelete = new Item("testForDelete", "testForDelete", 123L);
        tracker.add(forDelete);
        final int byId = tracker.indexOf("15");
        assertThat(byId, is(-1));
    }

    @Test
    public void whenDeleteThenReturnTrueOfOperation() {
        Tracker tracker = new Tracker();
        // Создаем трекер из трёх заявок.
        Item previous = new Item("test1", "testDescription1", 12L);
        tracker.add(previous);
        Item forDelete = new Item("testForDelete", "testForDelete", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(forDelete);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(next);
        // Проверяем весь возвращаемый массив трекера.
        assertThat(tracker.delete(forDelete.getId()), is(true));
    }

    @Test
    public void whenDeleteThenReturnNextIndex() {
        Tracker tracker = new Tracker();
        // Создаем трекер из трёх заявок.
        Item previous = new Item("test1", "testDescription1", 12L);
        tracker.add(previous);
        Item forDelete = new Item("testForDelete", "testForDelete", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(forDelete);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(next);
        tracker.delete(forDelete.getId());
        // Проверяем весь возвращаемый массив трекера.
        assertThat(tracker.indexOf(next.getId()), is(1));
    }

    @Test
    public void whenGetKeyThenReturnItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription1", 12L);
        Item forSearch = new Item("target", "targetDescription", 123L);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(previous);
        tracker.add(forSearch);
        tracker.add(next);
        Item[] result = new Item[] {forSearch};
        assertThat(tracker.findByName("target"), is(result));
    }
}
