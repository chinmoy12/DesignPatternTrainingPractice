package com.sourcenext.designpatterntrainingpractice.patterns.factory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.sourcenext.designpatterntrainingpractice.patterns.observer.ViewObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class MyView extends View {
    public abstract boolean isSelected();

    public abstract void setSelected(boolean flag);

    private List<ViewObserver> observers = new ArrayList<ViewObserver>();

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void attach(ViewObserver observer){
        observers.add(observer);
    }

    public void notifyAllObservers(MyView myView, float x, float y, float width, float height){
        for (ViewObserver observer : observers) {
            observer.updateView(myView, x, y, width, height);
        }
    }
}
