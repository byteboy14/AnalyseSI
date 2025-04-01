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
            public void setPanel(AnalysePanel panelCurrent) {

            }
        };
        observer.subscribeFrame(listener);

        Assert.assertTrue(observer.getListener() != null );

    }


    @After
    public void tearDown() throws Exception {
    }

    class AnalyseFrameObserverForTest extends AnalyseFrameObserver {

        public AnalyseFrameListener getListener() {
            return listener;
        }
    }
}