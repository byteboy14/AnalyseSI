package org.analyse.core.gui.command.asi;

import org.analyse.core.gui.command.Command;
import org.analyse.core.gui.command.CommandEvent;
import org.analyse.core.gui.frame.FrameObserver;
import org.analyse.core.state.AppState;
import org.analyse.core.state.AppStateManagement;
import org.analyse.core.util.save.AnalyseSave;

public abstract class ASICommand implements Command {

    protected AnalyseSave analyseSave;
    protected AppState state ;

    public ASICommand() {
        state = AppStateManagement.getInstance().getStateCopy();
        analyseSave = new AnalyseSave(state);

    }

    protected void executeWithState(VoidFunction analyseSaveFunc) {
        executeWithState(CommandEvent.IDLE, analyseSaveFunc);
    }

    protected void executeWithState(CommandEvent event ,
                                    VoidFunction analyseSaveFunc) {
        analyseSaveFunc.execute();
        eventExecution(event);

    }

    private void eventExecution(CommandEvent event ) {
        switch(event ) {
            case ON_FILE_OPENING:
                saveStateAndUpdateFrameTitle();
                setupDefaultPanelIfOpeningFileFirstTime();
                break;

            default:
                AppStateManagement.getInstance().saveState(state);
                break;
        }
    }

    private void saveStateAndUpdateFrameTitle(){
        AppStateManagement.getInstance().saveState(state, (state -> {
            FrameObserver.Instance()
                    .updateFrameTitle(state.getTitle());
        } ));
    }

    private void setupDefaultPanelIfOpeningFileFirstTime(){

        state = AppStateManagement.getInstance().getStateCopy();
        if(currentPanelIsDefaultStartupPanel()){
            //TODO : start dictionary table panel
            System.out.println(" change panel ");
        }
    }

    private Boolean currentPanelIsDefaultStartupPanel() {
        return state.getCurrentPanel().equals("HelpPanel");
    }


    @FunctionalInterface
    protected interface VoidFunction {
        void execute();
    }
}


