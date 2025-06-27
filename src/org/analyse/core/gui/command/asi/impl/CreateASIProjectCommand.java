package org.analyse.core.gui.command.asi.impl;

import org.analyse.core.gui.command.asi.ASICommand;

public class CreateASIProjectCommand extends ASICommand {
    @Override
    public void execute() {
        analyseSave.setNewOption(true);
        analyseSave.save();
        analyseSave.clear();
    }
}
