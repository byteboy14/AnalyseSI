package org.analyse.core.gui.frame;

public class AnalyseFrameObserver {

    protected AnalyseFrameListener listener ;

    public void subscribeFrame(AnalyseFrameListener listener) {
        this.listener = listener ;
    }

}
