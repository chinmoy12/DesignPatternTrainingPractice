package com.sourcenext.designpatterntrainingpractice.patterns.factory;

import android.content.Context;
import android.view.View;

import com.sourcenext.designpatterntrainingpractice.utils.ViewType;
import com.sourcenext.designpatterntrainingpractice.views.TriangleView;
import com.sourcenext.designpatterntrainingpractice.views.RectangleView;
import com.sourcenext.designpatterntrainingpractice.views.StraightLineView;

public class ViewFactoryDPT {
    public static MyView getView(Context context, ViewType shapeType) {
        if (shapeType == ViewType.RECTANGLE) {
            return new RectangleView(context);
        } else if (shapeType == ViewType.TRIANGLE) {
            return new TriangleView(context);
        } else if (shapeType == ViewType.STRAIGHTLINE) {
            return new StraightLineView(context);
        }
        return null;
    }
}
