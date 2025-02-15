package org.analyse.core.gui.command.asi.impl;

import org.analyse.core.gui.command.asi.ASICommand;

public class OpenASIProjectCommand extends ASICommand {

    private final String filename;

    public OpenASIProjectCommand(){
        filename = null ;
    }

    public OpenASIProjectCommand(String arg) {
        this.filename = arg;
    }

    @Override
    public void execute() {

        if (filename != null) analyseSave.open(filename);
        else
            analyseSave.open();
    }
}
