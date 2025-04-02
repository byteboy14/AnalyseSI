/*
 * 7 févr. 2005 - 11:19:31
 *
 * Navigator.java Copyright (C) 2004 Dreux Loic dreuxl@free.fr
 *
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.analyse.core.gui.panel.navigator;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.uif.lite.panel.SimpleInternalFrame;
import org.analyse.core.gui.action.BasicAction;
import org.analyse.core.util.Constantes;
import org.analyse.core.util.Utilities;

import javax.swing.*;
import java.awt.*;

public class Navigator extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 5561301850688044080L;
    private SimpleInternalFrame iFrame;
    private JPanel centre;
    private FormLayout layout;
    private PanelBuilder builder;
    private CellConstraints cc;
    private int inc;

    private NavigatorButtonObserver observer;

    public Navigator() {
        /* Construction du Navigator */
        super(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(4, 4, 0, 0));

        /* Construction de la Frame Interne*/
        iFrame = new SimpleInternalFrame(Utilities.getLangueMessage(Constantes.MESSAGE_NAVIGATEUR));
        layout = new FormLayout(
                "5px, 182px, 5px",
                "2mm, p, 2mm, p, 2mm, p, 2mm, p, 2mm, p, 2mm, p");
        builder = new PanelBuilder(layout);
        cc = new CellConstraints();
        inc = 2;

        this.add(iFrame);

        observer = new NavigatorButtonObserver();
    }

    /**
     * Ajoute un bouton dans la barre de Navigation
     *
     * @param action Action liée au bouton
     */
    public void addButton(BasicAction action) {

        builder.add(newButton(action), cc.xy(2, inc));
        inc += 2;

        if (centre != null)
            iFrame.remove(centre);

        centre = builder.getPanel();
        centre.setBackground(Color.white);
        iFrame.add(BorderLayout.CENTER, centre);
    }

    private NavigatorButton newButton(BasicAction action) {

        String actionName = action.getValue(Action.NAME).toString();

        action.addActionListener(
                e -> {
                    observer.notifyOnNavigateTo(actionName);
                }
        );
        NavigatorButton button = new NavigatorButton(action);
        observer.addListener(button);

        return button;
    }
}