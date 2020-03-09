package com.sourcenext.designpatterntrainingpractice.patterns.factory;

import android.content.Context;

import com.sourcenext.designpatterntrainingpractice.utils.ViewType;
import com.sourcenext.designpatterntrainingpractice.views.RectangleView;
import com.sourcenext.designpatterntrainingpractice.views.StraightLineView;
import com.sourcenext.designpatterntrainingpractice.views.TriangleView;

public class MyViewFactory {
    public static MyView getView(Context context, ViewType viewType) {
        if (viewType == ViewType.RECTANGLE) {
            return new RectangleView(context);
        } else if (viewType == ViewType.TRIANGLE) {
            return new TriangleView(context);
        } else if (viewType == ViewType.STRAIGHTLINE) {
            return new StraightLineView(context);
        }
        return null;
    }
}
