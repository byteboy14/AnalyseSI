package org.analyse.core.gui.shortcuts;


import org.analyse.core.gui.command.asi.impl.CreateASIProjectCommand;
import org.analyse.core.gui.command.asi.impl.OpenProjectASICommand;
import org.analyse.core.gui.command.asi.impl.SaveASICommand;
import org.analyse.core.gui.command.asi.impl.SaveAsASICommand;

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

    private void findShortCutAndExecuteCommand() {

        if (keyPressedEqualControl(KeyEvent.VK_N)) {
            newASIProject();
        }

        if (keyPressedEqualControl(KeyEvent.VK_O)) {
            openASIProject();
        }

        if (keyPressedEqualControl(KeyEvent.VK_S)) {
            saveASI();
        }

        if (keyPressedEqualControl(KeyEvent.VK_A)) {
            saveAsASI();
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

    protected void newASIProject() {
        new CreateASIProjectCommand().execute();
    }

    protected void openASIProject() {
        new OpenProjectASICommand().execute();
    }


    protected void saveASI() {
        new SaveASICommand().execute();
    }


    protected void saveAsASI() {
        new SaveAsASICommand().execute();
    }

    protected void setLastPressedKeyCode(int keyCode) {
        this.lastPressedKeyCode = keyCode;
    }


}
