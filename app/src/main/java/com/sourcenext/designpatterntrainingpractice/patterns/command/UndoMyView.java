package com.sourcenext.designpatterntrainingpractice.patterns.command;

public class UndoMyView implements CommandMyView {
    CommandMyView mCommandMyView;

    public UndoMyView(CommandMyView commandMyView) {
        mCommandMyView = commandMyView;
    }


    @Override
    public void executeCommandMyView() {
        mCommandMyView.executeCommandMyView();
    }
}
