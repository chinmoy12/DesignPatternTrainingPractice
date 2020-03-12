package com.sourcenext.designpatterntrainingpractice.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyView;
import com.sourcenext.designpatterntrainingpractice.utils.Constants;
import com.sourcenext.designpatterntrainingpractice.utils.Utils;

public class TriangleView extends MyView {
    Paint paint;
    boolean isSelected = false;

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean flag) {
        isSelected = flag;
    }

    public TriangleView(Context context) {
        super(context);
        init();
    }

    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected) {
            Utils.drawSelectedFrame(canvas);
        }
        Point a = new Point((getWidth() / 2), Constants.boundaryRectangleSize);
        Point b = new Point(Constants.boundaryRectangleSize, (getHeight() - Constants.boundaryRectangleSize));
        Point c = new Point((getWidth() - Constants.boundaryRectangleSize), (getHeight() - Constants.boundaryRectangleSize));

        Path path = new Path();
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        canvas.drawPath(path, paint);
    }

    private void init(){
        paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }
}
