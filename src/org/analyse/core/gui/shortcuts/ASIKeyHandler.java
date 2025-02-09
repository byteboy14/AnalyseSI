package org.analyse.core.gui.shortcuts;


import org.analyse.core.util.save.AnalyseSave;
import org.analyse.main.Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Gère les évènements clavier
 * ROUX Constant, MICHEL Arthur
 */

public class ASIKeyHandler extends KeyAdapter {
    int lasttyped;

    public void keyPressed(KeyEvent ke) {
//        if((int)ke.getKeyCode() == 17){
//            lasttyped = 17;
//        }
//        if((int)ke.getKeyCode() == 83 && lasttyped == 17){
//            AnalyseSave s = Main.analyseFrame.getAnalyseSave();
//            s.save();
//        }
//        if((int)ke.getKeyCode() != 17){
//            lasttyped = 0;
//        }

//        if (ke.getKeyCode() == 83 && lasttyped == 17) {
//            AnalyseSave s = Main.analyseFrame.getAnalyseSave();
//            s.save();
//        }

        System.out.println(" event : " + KeyEvent.getKeyText(ke.getKeyCode())
                .equals(KeyEvent.getKeyText(KeyEvent.VK_S)));
    }
}
