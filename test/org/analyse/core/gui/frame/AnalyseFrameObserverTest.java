package org.analyse.core.gui.frame;

import org.analyse.core.modules.AnalysePanel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnalyseFrameObserverTest {

    private AnalyseFrameObserverForTest observer ;

    @Before
    public void setUp() {
        observer = new AnalyseFrameObserverForTest();
    }

    @Test
    public void analyseFrameObserver() {
        Assert.assertTrue(observer != null );
    }

    @Test
    public void subscribe(){

        AnalyseFrameListener listener = new AnalyseFrameListener() {
            @Override
            public void onSetPanel(AnalysePanel panelCurrent) {

            }
        };
        observer.subscribeFrame(listener);

        Assert.assertTrue(observer.getListener() != null );

    }

    @Test
    public void setPanel_updatePanel(){

        AnalysePanel panel = new AnalysePanel("Dummy") {
            @Override
            public String getID() {
                return super.getID();
            }
        };

        observer.setPanel(panel);

        assertSame(observer.getCurrentPanel().getID(), panel.getID());
    }


    @After
    public void tearDown() throws Exception {
    }

    class AnalyseFrameObserverForTest extends AnalyseFrameObserver {

        private AnalysePanel currentPanel ;

        public AnalyseFrameListener getListener() {
            return listener;
        }

        @Override
        public void setPanel(AnalysePanel panel) {
            this.currentPanel = panel ;
        }

        public AnalysePanel getCurrentPanel() {
            return currentPanel;
        }
    }
}