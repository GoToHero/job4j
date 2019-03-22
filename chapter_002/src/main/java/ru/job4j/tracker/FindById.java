package ru.job4j.tracker;

public class FindById implements UserAction {

    private int key;
    private String name;

    public FindById(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by ID--------------");
        String id = input.ask("Please, provide item ID:");
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println("------------ Name : " + result.getName() + " Description: "
                    + result.getDescription() + "-----------");
        } else {
            System.out.println("The operation failed. No match found for specified ID.");
        }
    }

    @Override
    public String info() {
        return String.format("%d. %s", key, name);
    }
}
