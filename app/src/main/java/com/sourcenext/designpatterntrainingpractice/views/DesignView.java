package com.sourcenext.designpatterntrainingpractice.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class DesignView extends RelativeLayout {
    Paint paint;

    public DesignView(Context context) {
        super(context);
        init();
    }

    public DesignView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DesignView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(30, 50, 200, 350, paint);
    }
}
