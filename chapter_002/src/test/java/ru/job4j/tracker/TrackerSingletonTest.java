package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TrackerSingletonTest {

    @Test
    public void JustTracker() {
        Tracker firstTracker = new Tracker();
        Tracker secondTracker = new Tracker();

        assertTrue(firstTracker != secondTracker);
    }

    @Test
    public void TrackerSingleEagerEnumTest() {
        TrackerSingleEagerEnum firstTracker = TrackerSingleEagerEnum.INSTANCE;
        TrackerSingleEagerEnum secondTracker = TrackerSingleEagerEnum.INSTANCE;
        TrackerSingleEagerEnum thirdTracker = TrackerSingleEagerEnum.INSTANCE;

        assertTrue(firstTracker == secondTracker && secondTracker == thirdTracker);
    }

    @Test
    public void TrackerSingleStaticLazyTest() {
        TrackerSingleStaticLazy firstTracker = TrackerSingleStaticLazy.getInstance();
        TrackerSingleStaticLazy secondTracker = TrackerSingleStaticLazy.getInstance();
        TrackerSingleStaticLazy thirdTracker = TrackerSingleStaticLazy.getInstance();

        assertTrue(firstTracker == secondTracker && secondTracker == thirdTracker);
    }

    @Test
    public void TrackerSingleFinalEagerTest() {
        TrackerSingleFinalEager firstTracker = TrackerSingleFinalEager.getInstance();
        TrackerSingleFinalEager secondTracker = TrackerSingleFinalEager.getInstance();
        TrackerSingleFinalEager thirdTracker = TrackerSingleFinalEager.getInstance();

        assertTrue(firstTracker == secondTracker && secondTracker == thirdTracker);
    }

    @Test
    public void TrackerSinglePrivateLazyTest() {
        TrackerSinglePrivateLazy firstTracker = TrackerSinglePrivateLazy.getInstance();
        TrackerSinglePrivateLazy secondTracker = TrackerSinglePrivateLazy.getInstance();
        TrackerSinglePrivateLazy thirdTracker = TrackerSinglePrivateLazy.getInstance();

        assertTrue(firstTracker == secondTracker && secondTracker == thirdTracker);
    }
}
