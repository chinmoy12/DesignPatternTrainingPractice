package com.sourcenext.designpatterntrainingpractice.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoMyViewCommand {
    private List<CommandMyView> commandList = new ArrayList<CommandMyView>();

    public void setCommand(CommandMyView commandMyView){
        commandList.add(commandMyView);
    }

    public void runCommands(){
        for (CommandMyView commandMyView : commandList) {
            commandMyView.executeCommandMyView();
        }
        commandList.clear();
    }
}
