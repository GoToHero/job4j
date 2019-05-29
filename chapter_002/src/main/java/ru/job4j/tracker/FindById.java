package ru.job4j.tracker;

public class FindById extends BaseAction {

    public FindById(int key, String name) {
        super(key, name);
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
}
