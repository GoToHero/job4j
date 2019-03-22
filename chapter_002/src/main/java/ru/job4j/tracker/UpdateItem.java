package ru.job4j.tracker;

public class UpdateItem implements UserAction {

    private int key;
    private String name;

    public UpdateItem(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Edit item --------------");
        String id = input.ask("Please, provide item ID:");
        String name = input.ask("Please, provide new item name:");
        String desc = input.ask("Please, provide new item description:");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDescription());
    }

    @Override
    public String info() {
        return String.format("%d. %s", key, name);
    }
}
