package ru.job4j.tracker;

public class TrackerSingleFinalEager {
    private static final TrackerSingleFinalEager INSTANCE = new TrackerSingleFinalEager();

    private TrackerSingleFinalEager() {
    }

    public static TrackerSingleFinalEager getInstance() {
        return INSTANCE;
    }

    public Item init (Item model) {
        return model;
    }
}
