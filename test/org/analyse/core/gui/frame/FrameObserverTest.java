package org.analyse.core.gui.frame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameObserverTest {

    private FrameObserver observer;


    @Before
    public void setUp() {
        observer = FrameObserver.Instance();
    }

    @Test
    public void subscribeListener() {
        TestListener listener = new TestListener();
        observer.subscribeListener(listener);
        assertEquals("test", listener.title);

        listener = new TestListener("test2");

        observer.subscribeListener(listener);
        assertEquals("test2", listener.title);

    }

    @Test
    public void updateFrameTitle() {
        TestListener listener = new TestListener();
        observer.subscribeListener(listener);
        assertEquals("test", listener.title);

        observer.updateFrameTitle("test3");
        assertEquals("test3", listener.title);
    }

    @Test
    public void instance_conserveSameInstance() {

        TestListener listener = new TestListener();
        observer.subscribeListener(listener);

        observer.updateFrameTitle("test3");
        assertEquals("test3", listener.title);

        observer = FrameObserver.Instance();
        observer.updateFrameTitle("test2");
        assertEquals("test2", listener.title);

        observer = FrameObserver.Instance();
        observer.updateFrameTitle("testm");
        assertEquals("testm", listener.title);
    }


    private static class TestListener implements FrameListener {

        public String title;

        public TestListener() {
            title = "test";
        }

        public TestListener(String title) {
            this.title = title;
        }

        @Override
        public void updateTitle(String title) {
            this.title = title;
        }

        @Override
        public void openDefaultPanel() {

        }
    }
}