package org.analyse.core.gui.panel.navigator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NavigatorButtonObserverTest {

    private NavigatorButtonObserverForTest obs;

    @Before
    public void setup() {
        obs = new NavigatorButtonObserverForTest();
    }

    @Test
    public void addListener_addOne() {
        TestListener one = new TestListener();
        Assert.assertEquals(0, obs.getListeners());

        obs.addListener(one);

        Assert.assertEquals(1, obs.getListeners());
    }

    @Test
    public void addListener_addThree() {
        TestListener one = new TestListener();
        Assert.assertEquals(0, obs.getListeners());

        obs.addListener(one);

        Assert.assertEquals(1, obs.getListeners());

        TestListener two = new TestListener();

        obs.addListener(two);

        Assert.assertEquals(2, obs.getListeners());

        TestListener three = new TestListener();

        obs.addListener(three);

        Assert.assertEquals(3, obs.getListeners());
    }

    @Test
    public void notifyOnNavigateTo_One() {
        TestListener one = new TestListener("1");
        obs.addListener(one);

        obs.notifyOnNavigateTo("1");

        Assert.assertTrue(one.isNotified());

        obs.notifyOnNavigateTo("0");

        Assert.assertFalse(one.isNotified());
    }

    @Test
    public void notifyOnNavigateTo_Many() {
        TestListener one = new TestListener("1");
        obs.addListener(one);
        TestListener two = new TestListener("2");
        obs.addListener(two);
        TestListener three = new TestListener("3");
        obs.addListener(three);

        obs.notifyOnNavigateTo("1");

        Assert.assertTrue(one.isNotified());
        Assert.assertFalse(two.isNotified());
        Assert.assertFalse(three.isNotified());

        obs.notifyOnNavigateTo("2");
        Assert.assertTrue(two.isNotified());
        Assert.assertFalse(three.isNotified());
        Assert.assertFalse(one.isNotified());

        obs.notifyOnNavigateTo("3");
        Assert.assertTrue(three.isNotified());
        Assert.assertFalse(two.isNotified());
        Assert.assertFalse(one.isNotified());
    }


    private class TestListener implements NavigatorButtonListener {

        private boolean isNotified = false;
        private String actionName = "";

        public TestListener() {
            this.actionName = "";
        }

        public TestListener(String name) {
            this.actionName = name;
        }

        public boolean isNotified() {
            return isNotified;
        }

        @Override
        public void onNavigateTo(String actionName) {
            isNotified = (this.actionName.equals(actionName));
        }
    }

    private class NavigatorButtonObserverForTest extends NavigatorButtonObserver {

        public int getListeners() {
            return listeners.size();
        }
    }
}

