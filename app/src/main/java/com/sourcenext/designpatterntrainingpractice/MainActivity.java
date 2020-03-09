package com.sourcenext.designpatterntrainingpractice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.sourcenext.designpatterntrainingpractice.listeners.MoveViewTouchListener;
import com.sourcenext.designpatterntrainingpractice.patterns.factory.ViewFactoryDPT;
import com.sourcenext.designpatterntrainingpractice.utils.ViewType;
import com.sourcenext.designpatterntrainingpractice.views.DesignView;

public class MainActivity extends AppCompatActivity {
    DesignView designView;
    int press = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        designView = (DesignView) findViewById(R.id.designView);
    }

    public void drawRectangle(View view) {
        View v = ViewFactoryDPT.getView(this, ViewType.RECTANGLE);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(300,
                200);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        designView.addView(v);
    }

    public void drawCircle(View view) {
        View v = ViewFactoryDPT.getView(this, ViewType.TRIANGLE);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(300,
                300);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        designView.addView(v);
    }

    public void drawLine(View view) {
        View v = ViewFactoryDPT.getView(this, ViewType.STRAIGHTLINE);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(400,
                100);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        designView.addView(v);
    }
}
