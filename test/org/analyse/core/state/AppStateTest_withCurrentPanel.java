package org.analyse.core.state;

import org.analyse.core.gui.panel.HelpPanel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppStateTest_withCurrentPanel {

    private AppState state ;

    @Before
    public void setUp() throws Exception {
        state = new AppState();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCurrentPanel() {
        TestPanel helpPanel = new TestPanel();
        state.setCurrentPanel(helpPanel);

        Assert.assertEquals("TestPanel" , state.getCurrentPanel());
    }

    @Test
    public void getCurrentPanel_ClassNameDifferentForParentClass() {
        TestPanel helpPanel = new NewPanel();
        state.setCurrentPanel(helpPanel);

        Assert.assertEquals("NewPanel" , state.getCurrentPanel());
    }

    private class TestPanel {
        public TestPanel() {

        }
    }

    private class NewPanel extends TestPanel {
        public NewPanel() {

        }
    }
}