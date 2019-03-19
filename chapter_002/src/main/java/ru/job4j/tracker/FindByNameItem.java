package ru.job4j.tracker;

public class FindByNameItem implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by name--------------");
        String key = input.ask("Please, provide item name:");
        Item[] result = tracker.findByName(key);
        for (int index = 0; index < result.length; index++) {
            if (result[index] != null) {
                System.out.println("Item ID: " + result[index].getId() + " Name: " + result[index].getName()
                        + " Description: " + result[index].getDescription());
            }
        }
    }

    @Override
    public String info() {
        return "5. Search Item by Name.";
    }
}
