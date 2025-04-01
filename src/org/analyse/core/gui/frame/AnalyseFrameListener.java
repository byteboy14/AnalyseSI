package org.analyse.core.gui.frame;

import org.analyse.core.modules.AnalysePanel;

public interface AnalyseFrameListener {

    /**
     * Modifie le panel courant.
     *
     * @param panelCurrent
     *            nouveau panel
     */
    void onSetPanel(AnalysePanel panelCurrent);
}
