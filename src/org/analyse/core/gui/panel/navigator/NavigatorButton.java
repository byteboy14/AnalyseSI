package org.analyse.core.gui.panel.navigator;


import org.analyse.core.gui.action.BasicAction;

import javax.swing.*;
import java.awt.*;

class NavigatorButton extends JToggleButton implements NavigatorButtonListener
{

    private static final long serialVersionUID = -8635984393664103035L;

    private BasicAction basicAction ;
    public NavigatorButton(BasicAction action )
    {
        super(action);

        this.basicAction = action ;
        this.setOpaque(false);
        this.setBorder(null);
        this.setHorizontalAlignment(JButton.LEFT);

        this.setForeground(new Color(70,47,47));
    }


    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        super.paintComponent(g2d);
    }

    @Override
    public void onNavigateTo(String actionName) {

        if(buttonIsNotNotifiedBy(actionName)) {
            desactivateButton();
        }
    }

    private Boolean buttonIsNotNotifiedBy(String actionName) {
        return !getActionName().equals(actionName);
    }

    private String getActionName() {

        return basicAction.getValue(BasicAction.NAME).toString();
    }

    private void desactivateButton(){
        setSelected(false);
    }
}
