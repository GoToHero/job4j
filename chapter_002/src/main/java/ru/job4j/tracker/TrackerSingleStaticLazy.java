package ru.job4j.tracker;

public class TrackerSingleStaticLazy {
    private static TrackerSingleStaticLazy instance;

    private TrackerSingleStaticLazy(){

    }

    public static TrackerSingleStaticLazy getInstance() {
        if (instance == null) {
            instance = new TrackerSingleStaticLazy();
        }
        return instance;
    }

    public Item init (Item model) {
        return model;
    }
}
