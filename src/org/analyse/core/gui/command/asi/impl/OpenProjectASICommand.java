package org.analyse.core.gui.command.asi.impl;

import org.analyse.core.gui.command.CommandEvent;
import org.analyse.core.gui.command.asi.ASICommand;

public class OpenProjectASICommand extends ASICommand {

    private final String filename;

    public OpenProjectASICommand() {
        filename = null;
    }

    public OpenProjectASICommand(String arg) {
        this.filename = arg;
    }

    @Override
    public void execute() {

        executeWithState(CommandEvent.ON_FILE_OPENING, ()->{
            if (filename != null) analyseSave.open(filename);
            else
                analyseSave.open();
        });

    }
}
