package com.sourcenext.designpatterntrainingpractice.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyView;
import com.sourcenext.designpatterntrainingpractice.utils.Utils;

public class RectangleView extends MyView {
    Paint paint;
    boolean isSelected = true;
    public RectangleView(Context context) {
        super(context);
        init();
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected) {
            Utils.drawSelectedFrame(canvas);
        }




        canvas.drawRect(30, 30, getWidth()-30, getHeight()-30, paint);
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
    }
}
