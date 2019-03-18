package ru.job4j.tracker;

public class DeleteItem implements UserAction {

    @Override
    public int key() {
        return DELETE;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete item --------------");
        String id = input.ask("Please, provide item ID:");
        tracker.delete(id);
    }

    @Override
    public String info() {
        return "Item deleted.";
    }
}