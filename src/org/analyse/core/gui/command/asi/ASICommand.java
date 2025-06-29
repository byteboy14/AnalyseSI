package org.analyse.core.gui.command.asi;

import org.analyse.core.gui.command.Command;
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
        analyseSaveFunc.execute();
        AppStateManagement.getInstance().saveState(state, (state -> {
            FrameObserver.Instance()
                    .updateFrameTitle(state.getTitle());
        } ));
    }


    @FunctionalInterface
    protected interface VoidFunction {
        void execute();
    }
}


