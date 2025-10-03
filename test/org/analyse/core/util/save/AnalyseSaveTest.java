package org.analyse.core.util.save;


import org.analyse.core.state.AppState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnalyseSaveTest {

    private AnalyseSaveForTest analyseSave;

    @Before
    public void setup() {
        this.analyseSave = new AnalyseSaveForTest();
    }

    @Test
    public void initConstructor() {
        assertNotNull(analyseSave);
    }

    @Test
    public void save_ForTheFirstTime() {
        this.analyseSave.saveForTheFirstTime();

        assertTrue(analyseSave.isSaveAsPushed);
        assertFalse(analyseSave.isSavePushed);
    }

    @Test
    public void save_afterTheFirstTime() {
        this.analyseSave.saveAfterTheFirstTime();

        assertTrue(analyseSave.isSavePushed);
        assertFalse(analyseSave.isSaveAsPushed);
    }

    @After
    public void tearDown(){
        this.analyseSave.reinitState();
    }


    private class AnalyseSaveForTest extends AnalyseSave {
        public boolean isSaveAsPushed = false;
        public boolean isSavePushed = false;

        public void saveForTheFirstTime() {
            this.state.setFileName(new AppState().getFileName());
            this.save();
        }

        public void saveAfterTheFirstTime() {
            this.state.setFileName(" file name");
            this.save();
        }

        @Override
        public void save() {
            super.save();
            isSavePushed = isSave() ;
        }

        @Override
        public void saveAs() {
            isSaveAsPushed = true;
        }

        @Override
        protected void executeSaving() {
            // leave empty
        }

        public void reinitState(){
            isSavePushed = false ;
            isSaveAsPushed = false ;
        }
    }
}