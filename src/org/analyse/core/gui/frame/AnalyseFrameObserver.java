package org.analyse.core.gui.frame;

import org.analyse.core.modules.AnalysePanel;

public class AnalyseFrameObserver {

    protected AnalyseFrameListener listener ;

    public void subscribeFrame(AnalyseFrameListener listener) {
        this.listener = listener ;
    }

    public void setPanel(AnalysePanel panel) {
        listener.onSetPanel(panel);
    }
}
