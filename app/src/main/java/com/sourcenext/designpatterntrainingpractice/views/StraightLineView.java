package com.sourcenext.designpatterntrainingpractice.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class StraightLineView extends View {
    Paint paint;
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
        canvas.drawLine(0, getHeight()/2, getWidth(), getHeight()/2, paint);
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
    }
}
