package org.analyse.core.gui.frame;

public class FrameObserver {
    private FrameListener listener = null;
    private static FrameObserver observer = null;

    private FrameObserver() {

    }

    public void subscribeListener(FrameListener listener) {
        this.listener = listener;
    }

    public void updateFrameTitle(String title) {
        listener.updateTitle(title);
    }

    public void openDefaultPanel() {
        listener.openDefaultPanel();
    }

    public static FrameObserver Instance() {
        if (observer == null) observer = new FrameObserver();

        return observer;
    }
}
