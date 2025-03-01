package org.analyse.core.gui.command.asi.impl;

import org.analyse.core.gui.command.asi.ASICommand;

public class SaveASICommand extends ASICommand {
    @Override
    public void execute() {
        analyseSave.save();
    }
}
