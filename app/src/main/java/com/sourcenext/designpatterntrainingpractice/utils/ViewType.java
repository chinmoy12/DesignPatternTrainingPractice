package com.sourcenext.designpatterntrainingpractice.utils;

public enum ViewType {
    RECTANGLE(1), TRIANGLE(2), STRAIGHTLINE(3);

    private int viewId;

    ViewType(int value) {
        this.viewId = value;
    }
}
