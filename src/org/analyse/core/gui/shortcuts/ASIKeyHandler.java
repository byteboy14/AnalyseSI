package org.analyse.core.gui.shortcuts;


import org.analyse.core.modules.AnalysePanel;
import org.analyse.core.modules.ClipboardInterface;
import org.analyse.core.modules.UndoInterface;
import org.analyse.core.util.save.AnalyseSave;
import org.analyse.main.Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Gère les évènements clavier
 */

public class ASIKeyHandler extends KeyAdapter {

    private int pressedKeyCode;

    private int lastPressedKeyCode;


    public void keyPressed(KeyEvent ke) {

        setPressedKeyCode(ke.getKeyCode());

        findShortCutAndExecuteCommand();

        setLastPressedKeyCode(ke.getKeyCode());

    }



    protected void setPressedKeyCode(int keyCode) {
        this.pressedKeyCode = keyCode;
    }

    private void findShortCutAndExecuteCommand(){

        if(keyPressedEqualControl(KeyEvent.VK_N)){
            newASIProject();
        }

        if(keyPressedEqualControl(KeyEvent.VK_O)){
            openASIProject();
        }

        if (keyPressedEqualControl(KeyEvent.VK_S)) {
            saveASI();
        }

        if (keyPressedEqualControl(KeyEvent.VK_A)) {
            saveAsASI();
        }

        if (keyPressedEqualControl(KeyEvent.VK_Z)) {
            undoOperation();
        }

        if (keyPressedEqualControl(KeyEvent.VK_Y)) {
            redoOperation();
        }

        if (keyPressedEqualControl(KeyEvent.VK_X)) {
            cutOperation();
        }

        if (keyPressedEqualControl(KeyEvent.VK_V)) {
            pasteOperation();
        }
    }

    protected boolean keyPressedEqualControl(int keyEventCode) {

        return controlKeyIsPressed() && keyEventEqual(keyEventCode);
    }

    private boolean controlKeyIsPressed() {
        return compareNewKeyCodeToKeyEventCode(lastPressedKeyCode, KeyEvent.VK_CONTROL);
    }


    protected boolean keyEventEqual(int keyEventCode) {
        return compareNewKeyCodeToKeyEventCode(pressedKeyCode, keyEventCode);
    }

    private boolean compareNewKeyCodeToKeyEventCode(int newKeyCode, int keyEventCode) {
        return KeyEvent.getKeyText(newKeyCode)
                .equals(KeyEvent.getKeyText(keyEventCode));
    }

    protected void saveASI() {
        AnalyseSave s = Main.analyseFrame.getAnalyseSave();
        s.save();
    }

    protected void newASIProject(){
        AnalyseSave s = Main.analyseFrame.getAnalyseSave();
        s.setNewOption(true) ;
        s.save();
        s.clear();
    }

    protected  void openASIProject(){
        AnalyseSave s = Main.analyseFrame.getAnalyseSave();
        s.open();
    }

    protected  void saveAsASI(){
        AnalyseSave s = Main.analyseFrame.getAnalyseSave();
        s.saveAs();
    }

    protected  void undoOperation(){
        UndoInterface u;
        AnalysePanel p = Main.analyseFrame.getCurrentPanel();
        try {
            u = (UndoInterface) p;
            u.undo();
        } catch (ClassCastException exp) {
            System.err.println(exp);
        }

    }

    protected  void redoOperation(){
        UndoInterface u;
        AnalysePanel p = Main.analyseFrame.getCurrentPanel();
        try {
            u = (UndoInterface) p;
            u.redo();
        } catch (ClassCastException exp) {
            System.err.println(exp);
        }
    }

    protected  void cutOperation(){
        ClipboardInterface c;
        AnalysePanel p = Main.analyseFrame.getCurrentPanel();
        try {
            c = (ClipboardInterface) p;
            c.cut();
        } catch (ClassCastException exp) {
            System.err.println(exp);
        }
    }

    protected  void pasteOperation(){
        ClipboardInterface c;
        AnalysePanel p = Main.analyseFrame.getCurrentPanel();

        try {
            c = (ClipboardInterface) p;
            c.paste();
        } catch (ClassCastException exp) {
            System.err.println(exp);
        }
    }



    protected void setLastPressedKeyCode(int keyCode) {
        this.lastPressedKeyCode = keyCode;
    }


}
