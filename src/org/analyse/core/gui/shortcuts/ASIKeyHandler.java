package org.analyse.core.gui.shortcuts;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Gère les évènements clavier
 * ROUX Constant, MICHEL Arthur
 */

public class ASIKeyHandler extends KeyAdapter {

    private int pressedKeyCode;

    protected void setPressedKeyCode(int keyCode) {
        this.pressedKeyCode = keyCode ;
    }

    private int lastPressedKeyCode ;
    protected void setLastPressedKeyCode(int keyCode){
        this.lastPressedKeyCode = keyCode ;
    }

    public void keyPressed(KeyEvent ke) {

        setPressedKeyCode(ke.getKeyCode());

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

        if(keyEventEqualControl(KeyEvent.VK_S)){

        }


        setLastPressedKeyCode(ke.getKeyCode());
        System.out.println(" event : " + KeyEvent.getKeyText(ke.getKeyCode())
                + " ctrl "+ keyEventEqual(KeyEvent.VK_CONTROL) );
    }

    protected boolean keyEventEqualControl(int keyEventCode) {

        return controlKeyIsPressed() && keyEventEqual(keyEventCode);
    }

    private boolean controlKeyIsPressed() {
        return compareNewKeyCodeToKeyEventCode(lastPressedKeyCode, KeyEvent.VK_CONTROL) ;
    }


    protected boolean keyEventEqual(int keyEventCode ) {
        return compareNewKeyCodeToKeyEventCode(pressedKeyCode, keyEventCode) ;
    }

    private boolean compareNewKeyCodeToKeyEventCode(int newKeyCode , int keyEventCode){
        return KeyEvent.getKeyText(newKeyCode)
                .equals(KeyEvent.getKeyText(keyEventCode)) ;
    }


}
