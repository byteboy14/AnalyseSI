package org.analyse.core.gui.shortcuts;

import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class ASIKeyHandlerTest {

    private ASIKeyHandler keyHandler ;

    @Before
    public void setUp() {
        keyHandler = new ASIKeyHandler();
    }

    @Test
    public void keyEventEqualControl_controlNotPressed() {

        assertFalse(keyHandler.keyEventEqualControl(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_O);
        assertFalse(keyHandler.keyEventEqualControl(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_CONTROL);
        assertFalse(keyHandler.keyEventEqualControl(KeyEvent.VK_CONTROL));
    }

    @Test
    public void keyEventEqualControl_controlIsPressed() {

        keyHandler.setLastPressedKeyCode(KeyEvent.VK_CONTROL);
        assertFalse(keyHandler.keyEventEqualControl(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_O);
        assertTrue(keyHandler.keyEventEqualControl(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_S);
        assertFalse(keyHandler.keyEventEqualControl(KeyEvent.VK_O));

        assertTrue(keyHandler.keyEventEqualControl(KeyEvent.VK_S));
    }

    @Test
    public void keyEventEqual_sameWithLastPressedKey() {
        assertFalse(keyHandler.keyEventEqual(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_O);
        assertTrue(keyHandler.keyEventEqual(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_S);
        assertFalse(keyHandler.keyEventEqual(KeyEvent.VK_O));

        assertTrue(keyHandler.keyEventEqual(KeyEvent.VK_S));
    }
}