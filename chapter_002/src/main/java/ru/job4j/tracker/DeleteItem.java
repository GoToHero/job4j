package ru.job4j.tracker;

public class DeleteItem implements UserAction {

    private int key;
    private String name;

    public DeleteItem(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete item --------------");
        String id = input.ask("Please, provide item ID:");
        tracker.delete(id);
    }

    @Override
    public String info() {
        return String.format("%d. %s", key, name);
    }
}
