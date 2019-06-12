package ru.job4j.tracker;

public class TrackerSinglePrivateLazy {
    private TrackerSinglePrivateLazy() {

    }

    public static TrackerSinglePrivateLazy getInstance() {
        return Holder.INSTANCE;
    }

    public Item init (Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSinglePrivateLazy INSTANCE = new TrackerSinglePrivateLazy();
    }
}
