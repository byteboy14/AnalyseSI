package org.analyse.core.gui.panel.navigator;

import java.util.ArrayList;
import java.util.List;

class NavigatorButtonObserver {
    protected List<NavigatorButtonListener> listeners ;

    public NavigatorButtonObserver(){
        listeners = new ArrayList<>();
    }

    public void addListener(NavigatorButtonListener listener) {

        listeners.add(listener);
    }

    public void notifyOnNavigateTo(String actionName) {

        listeners.forEach(listener ->{
            listener.onNavigateTo(actionName);
        } );
    }
}

