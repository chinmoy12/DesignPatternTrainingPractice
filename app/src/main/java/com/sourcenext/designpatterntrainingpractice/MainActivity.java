package com.sourcenext.designpatterntrainingpractice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sourcenext.designpatterntrainingpractice.listeners.MoveViewTouchListener;
import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyView;
import com.sourcenext.designpatterntrainingpractice.patterns.factory.ViewFactoryDPT;
import com.sourcenext.designpatterntrainingpractice.patterns.observer.ViewObserver;
import com.sourcenext.designpatterntrainingpractice.utils.ViewType;
import com.sourcenext.designpatterntrainingpractice.views.DesignView;

public class MainActivity extends AppCompatActivity implements ViewObserver {
    DesignView designView;
    int press = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        designView = (DesignView) findViewById(R.id.designView);
    }

    public void drawRectangle(View view) {
        MyView v = ViewFactoryDPT.getView(this, ViewType.RECTANGLE);
        v.attach(this);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(300,
                200);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        designView.addView(v);
    }

    public void drawCircle(View view) {
        MyView v = ViewFactoryDPT.getView(this, ViewType.TRIANGLE);
        v.attach(this);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(300,
                300);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        designView.addView(v);
    }

    public void drawLine(View view) {
        MyView v = ViewFactoryDPT.getView(this, ViewType.STRAIGHTLINE);
        v.attach(this);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(400,
                100);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        designView.addView(v);
    }

    @Override
    public void updateView(float x, float y, float width, float height) {
        ((TextView) findViewById(R.id.shapeX)).setText("X: " + (int) x);
        ((TextView) findViewById(R.id.shapeY)).setText("Y: " + (int) y);
        ((TextView) findViewById(R.id.shapeWidth)).setText("Width: " + (int) width);
        ((TextView) findViewById(R.id.shapeHeight)).setText("Height: " + (int) height);
    }
}
