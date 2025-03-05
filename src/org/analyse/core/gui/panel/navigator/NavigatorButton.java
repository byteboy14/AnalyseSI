package org.analyse.core.gui.panel.navigator;


import javax.swing.*;
import java.awt.*;

class NavigatorButton extends JButton
{

    private static final long serialVersionUID = -8635984393664103035L;

    public NavigatorButton(Action action )
    {
        super(action);

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
}
