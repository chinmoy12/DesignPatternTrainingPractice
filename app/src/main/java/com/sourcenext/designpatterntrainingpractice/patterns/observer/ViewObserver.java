package com.sourcenext.designpatterntrainingpractice.patterns.observer;

import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyView;

public interface ViewObserver {
    void updateView(MyView myView, float x, float y, float width, float height);
}
