package com.sourcenext.designpatterntrainingpractice.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyView;
import com.sourcenext.designpatterntrainingpractice.utils.Constants;
import com.sourcenext.designpatterntrainingpractice.utils.Utils;

public class StraightLineView extends MyView {
    Paint paint;
    boolean isSelected = false;

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void setSelected(boolean flag) {
        isSelected = flag;
    }

    public StraightLineView(Context context) {
        super(context);
        init();
    }

    public StraightLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StraightLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected) {
            Utils.drawSelectedFrame(canvas);
        }
        canvas.drawLine(Constants.boundaryRectangleSize, getHeight()/2, (getWidth() - Constants.boundaryRectangleSize), getHeight()/2, paint);
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
    }
}
