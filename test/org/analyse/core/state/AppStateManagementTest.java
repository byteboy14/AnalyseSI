package org.analyse.core.state;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppStateManagementTest {

    private AppStateManagement stateManagement;

    @Before
    public void setUp() {
        stateManagement = AppStateManagement.getNewInstance();
    }

    @Test
    public void getInstance_sameInstance() {
        String fileName = "file name ";

        assertEquals("Should be the same ", "",
                stateManagement.getStateCopy().getFileName());

        stateManagement.getStateCopy().setFileName(fileName);

        AppState state = AppStateManagement.getInstance().getStateCopy();

        assertEquals("Should be the same ", fileName, state.getFileName());
    }

    @Test
    public void saveState() {

        AppState state = new AppState();
        state.setFileName("file name ");

        assertNotEquals("Should not be the same ", state.getFileName(),
                stateManagement.getStateCopy().getFileName());

        stateManagement.saveState(state);

        assertEquals("Should be the same ", state.getFileName(),
                AppStateManagement.getInstance().getStateCopy().getFileName());
    }

}
