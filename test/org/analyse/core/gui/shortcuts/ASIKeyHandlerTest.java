package org.analyse.core.gui.shortcuts;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class ASIKeyHandlerTest {

    private TestableASIKeyHandler keyHandler ;

    @Before
    public void setUp() {
        keyHandler = new TestableASIKeyHandler();
    }


    @Test
    public void keyPressed_saveFeatureCalled() {

        assertFalse(keyHandler.isSaveCalled);

        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_CONTROL));

        assertFalse(keyHandler.isSaveCalled);
        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_S));

        assertTrue(keyHandler.isSaveCalled);
    }

    @Test
    public void keyPressed_newProjectFeatureCalled() {

        assertFalse(keyHandler.isNewCalled);

        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_CONTROL));

        assertFalse(keyHandler.isNewCalled);
        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_N));

        assertTrue(keyHandler.isNewCalled);
    }

    @Test
    public void keyPressed_safeKeyPressedCombination() {

        assertFalse(keyHandler.isSaveCalled);

        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_CONTROL));

        assertFalse(keyHandler.isSaveCalled);
        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_S));

        assertTrue(keyHandler.isSaveCalled);
        keyHandler.isSaveCalled = false ;

        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_S));
        assertFalse(keyHandler.isSaveCalled);

        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_CONTROL));
        keyHandler.keyPressed(new EmptyKeyEvent(KeyEvent.VK_C));

        assertFalse(keyHandler.isSaveCalled);
    }


    @Test
    public void keyPressedEqualControl_controlNotPressed() {

        assertFalse(keyHandler.keyPressedEqualControl(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_O);
        assertFalse(keyHandler.keyPressedEqualControl(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_CONTROL);
        assertFalse(keyHandler.keyPressedEqualControl(KeyEvent.VK_CONTROL));
    }

    @Test
    public void keyPressedEqualControl_controlIsPressed() {

        keyHandler.setLastPressedKeyCode(KeyEvent.VK_CONTROL);
        assertFalse(keyHandler.keyPressedEqualControl(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_O);
        assertTrue(keyHandler.keyPressedEqualControl(KeyEvent.VK_O));

        keyHandler.setPressedKeyCode(KeyEvent.VK_S);
        assertFalse(keyHandler.keyPressedEqualControl(KeyEvent.VK_O));

        assertTrue(keyHandler.keyPressedEqualControl(KeyEvent.VK_S));
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


    private class TestableASIKeyHandler extends ASIKeyHandler {
        boolean isSaveCalled = false ;

        @Override
        protected  void saveASI(){
            isSaveCalled = true ;
        }

        boolean isNewCalled = false ;

        @Override
        protected  void newASIProject(){
            isNewCalled = true ;
        }
    }

    private class EmptyKeyEvent extends KeyEvent {

        public EmptyKeyEvent(int keyCode){
            super(new Component() {
            }, 0, 0, 0, 0);

            setKeyCode(keyCode);

        }
    }

}