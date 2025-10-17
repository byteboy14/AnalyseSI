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

    @Test
    public void open_forTheFirstTime() {
        analyseSave.openForTheFirstTime();

        assertTrue(analyseSave.isOpening);
        assertFalse(analyseSave.isSavePushed);
        assertFalse(analyseSave.isSaveAsPushed);
        assertFalse(analyseSave.askToSave);
    }

    @Test
    public void open_afterTheFirstTime_projectSaved() {
        analyseSave.openAfterTheFirstTimeWithProjectSaved();

        assertTrue(analyseSave.isOpening);
        assertFalse(analyseSave.isSavePushed);
        assertFalse(analyseSave.isSaveAsPushed);
        assertFalse(analyseSave.askToSave);
    }

    @Test
    public void open_afterTheFirstTime_projectNotSaved() {
        analyseSave.openAfterTheFirstTime();

        assertTrue(analyseSave.isOpening);
        assertFalse(analyseSave.isSavePushed);
        assertFalse(analyseSave.isSaveAsPushed);
        assertTrue(analyseSave.askToSave);
    }

    @After
    public void tearDown(){
        this.analyseSave.reinitState();
    }


    private static class AnalyseSaveForTest extends AnalyseSave {
        public boolean isSaveAsPushed = false;
        public boolean isSavePushed = false;
        public boolean isOpening = false ;
        public boolean askToSave = false ;

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

        public void openForTheFirstTime() {
            setSave(false);
            state.setFileName("");
            open();
        }

        public void openAfterTheFirstTime() {
            setSave(false);
            state.setFileName("documentAsi.asi");
            open();
        }

        public void openAfterTheFirstTimeWithProjectSaved() {
            setSave(true);
            state.setFileName("documentAsi.asi");
            open();
        }

        @Override
        protected  String chooseFile(String mode ){
            isOpening = true ;
            return "";
        }

        @Override
        protected int askToSaveDialog() {
            askToSave = true ;
            return 0;
        }

        public void reinitState(){
            isSavePushed = false ;
            isSaveAsPushed = false ;
            isOpening = false ;
            askToSave = false ;
        }
    }
}