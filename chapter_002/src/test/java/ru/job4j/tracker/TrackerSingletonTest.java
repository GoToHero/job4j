package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingletonTest {

    @Test
    public void JustTracker() {
        Tracker firstTracker = new Tracker();
        Tracker secondTracker = new Tracker();
        boolean result = false;
        if (firstTracker != secondTracker) {
            result = true;
        }

        assertThat(result, is(true));
    }

    @Test
    public void TrackerSingleEagerEnumTest() {
        TrackerSingleEagerEnum firstTracker = TrackerSingleEagerEnum.INSTANCE;
        TrackerSingleEagerEnum secondTracker = TrackerSingleEagerEnum.INSTANCE;
        TrackerSingleEagerEnum thirdTracker = TrackerSingleEagerEnum.INSTANCE;

        assertThat(firstTracker, is(thirdTracker));
    }

    @Test
    public void TrackerSingleStaticLazyTest() {
        TrackerSingleStaticLazy firstTracker = TrackerSingleStaticLazy.getInstance();
        TrackerSingleStaticLazy secondTracker = TrackerSingleStaticLazy.getInstance();
        TrackerSingleStaticLazy thirdTracker = TrackerSingleStaticLazy.getInstance();

        assertThat(firstTracker, is(thirdTracker));
    }

    @Test
    public void TrackerSingleFinalEagerTest() {
        TrackerSingleFinalEager firstTracker = TrackerSingleFinalEager.getInstance();
        TrackerSingleFinalEager secondTracker = TrackerSingleFinalEager.getInstance();
        TrackerSingleFinalEager thirdTracker = TrackerSingleFinalEager.getInstance();

        assertThat(firstTracker, is(thirdTracker));
    }

    @Test
    public void TrackerSinglePrivateLazyTest() {
        TrackerSinglePrivateLazy firstTracker = TrackerSinglePrivateLazy.getInstance();
        TrackerSinglePrivateLazy secondTracker = TrackerSinglePrivateLazy.getInstance();
        TrackerSinglePrivateLazy thirdTracker = TrackerSinglePrivateLazy.getInstance();

        assertThat(firstTracker, is(thirdTracker));
    }
}
