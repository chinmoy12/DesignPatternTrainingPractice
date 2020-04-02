package com.sourcenext.designpatterntrainingpractice.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sourcenext.designpatterntrainingpractice.R;
import com.sourcenext.designpatterntrainingpractice.listeners.MoveViewTouchListener;
import com.sourcenext.designpatterntrainingpractice.patterns.command.UndoRedoMyViewCommand;
import com.sourcenext.designpatterntrainingpractice.patterns.composite.MyViewComposite;
import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyView;
import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyViewFactory;
import com.sourcenext.designpatterntrainingpractice.patterns.observer.ViewObserver;
import com.sourcenext.designpatterntrainingpractice.utils.ViewType;
import com.sourcenext.designpatterntrainingpractice.views.DesignView;

public class MainActivity extends AppCompatActivity implements ViewObserver, View.OnTouchListener {
    DesignView designView;
    MyViewComposite myViewComposite;
    UndoRedoMyViewCommand undoRedoMyViewCommand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        designView = (DesignView) findViewById(R.id.designView);
        designView.setOnTouchListener(this);
        myViewComposite = new MyViewComposite(this);
        undoRedoMyViewCommand = new UndoRedoMyViewCommand();
    }

    public void drawRectangle(View view) {
        MyView v = MyViewFactory.getView(this, ViewType.RECTANGLE);
        v.attach(this);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(500,
                300);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        myViewComposite.addMyView(v);
        designView.addView(v);
    }

    public void drawTriangle(View view) {
        MyView v = MyViewFactory.getView(this, ViewType.TRIANGLE);
        v.attach(this);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(300,
                300);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        myViewComposite.addMyView(v);
        designView.addView(v);
    }

    public void drawLine(View view) {
        MyView v = MyViewFactory.getView(this, ViewType.STRAIGHTLINE);
        v.attach(this);
        RelativeLayout.LayoutParams layout_description = new RelativeLayout.LayoutParams(500,
                150);
        v.setLayoutParams(layout_description);
        v.setOnTouchListener(new MoveViewTouchListener(v));
        myViewComposite.addMyView(v);
        designView.addView(v);
    }

    @Override
    public void updateView(MyView myView, float x, float y, float width, float height) {
        for (int i = 0; i < myViewComposite.getViewListsSize(); i++) {
            MyView mv = myViewComposite.getViewFromList(i);
            if (!mv.equals(myView)) {
                mv.setSelected(false);
            }
            mv.invalidate();
        }

        ((TextView) findViewById(R.id.shapeX)).setText("X: " + (int) x);
        ((TextView) findViewById(R.id.shapeY)).setText("Y: " + (int) y);
        ((TextView) findViewById(R.id.shapeWidth)).setText("Width: " + (int) width);
        ((TextView) findViewById(R.id.shapeHeight)).setText("Height: " + (int) height);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
//        updateView(0, 0, 0, 0);
        return false;
    }

    public void undoAction(View view) {
//        undoRedoMyViewCommand.setCommand(new UndoMyView());
        Toast.makeText(this, "Will be added later", Toast.LENGTH_SHORT).show();
    }

    public void redoAction(View view) {
//        undoRedoMyViewCommand.setCommand(new RedoMyView());
        Toast.makeText(this, "Will be added later", Toast.LENGTH_SHORT).show();
    }
}
