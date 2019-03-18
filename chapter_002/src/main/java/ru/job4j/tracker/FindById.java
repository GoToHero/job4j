package ru.job4j.tracker;

public class FindById implements UserAction {

    @Override
    public int key() {
        return FINDNAME;
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
        return "Item has found.";
    }
}
