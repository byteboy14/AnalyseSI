package org.analyse.core.gui.command.asi;

import org.analyse.core.gui.command.Command;
import org.analyse.core.util.save.AnalyseSave;

public abstract class ASICommand implements Command {

    protected AnalyseSave analyseSave;

    public ASICommand() {
        analyseSave = new AnalyseSave();
    }
}
