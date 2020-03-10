package com.sourcenext.designpatterntrainingpractice.patterns.command;

public class RedoMyView implements CommandMyView {
    CommandMyView mCommandMyView;

    public RedoMyView(CommandMyView commandMyView) {
        mCommandMyView = commandMyView;
    }

    @Override
    public void executeCommandMyView() {
        mCommandMyView.executeCommandMyView();
    }
}
