package com.sourcenext.designpatterntrainingpractice.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Utils {
    public static void drawSelectedFrame(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(Constants.boundaryStrokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        // Top line
        canvas.drawLine((Constants.boundaryRectangleSize / 2), (Constants.boundaryRectangleSize / 2), (float) (canvas.getWidth() - Constants.boundaryRectangleSize / 2), (Constants.boundaryRectangleSize / 2), paint);
        // Left line
        canvas.drawLine((Constants.boundaryRectangleSize / 2), (Constants.boundaryRectangleSize / 2), (Constants.boundaryRectangleSize / 2), (canvas.getHeight() - (Constants.boundaryRectangleSize / 2)), paint);
        // Bottom line
        canvas.drawLine(0, (canvas.getHeight() - (Constants.boundaryRectangleSize / 2)), canvas.getWidth(), (canvas.getHeight() - (Constants.boundaryRectangleSize / 2)), paint);
        // Right line
        canvas.drawLine((canvas.getWidth() - (Constants.boundaryRectangleSize / 2)), 0, (canvas.getWidth() - (Constants.boundaryRectangleSize / 2)), canvas.getHeight(), paint);

        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(Constants.boundaryStrokeWidth);
        paint.setStyle(Paint.Style.FILL);
        // Top 3 rectangle of boundary selection
        canvas.drawRect(0, 0, Constants.boundaryRectangleSize, Constants.boundaryRectangleSize, paint);
        canvas.drawRect((float) (canvas.getWidth() / 2 - Constants.boundaryRectangleSize / 2), 0, (float) (canvas.getWidth() / 2 + Constants.boundaryRectangleSize / 2), Constants.boundaryRectangleSize, paint);
        canvas.drawRect((canvas.getWidth() - Constants.boundaryRectangleSize), 0, canvas.getWidth(), Constants.boundaryRectangleSize, paint);
        // Middle 2 rectangle of boundary selection
        canvas.drawRect(0, (float) (canvas.getHeight() / 2 - Constants.boundaryRectangleSize / 2), Constants.boundaryRectangleSize, (float) (canvas.getHeight() / 2 + Constants.boundaryRectangleSize / 2), paint);
        canvas.drawRect((canvas.getWidth() - Constants.boundaryRectangleSize), (float) (canvas.getHeight() / 2 - Constants.boundaryRectangleSize / 2), canvas.getWidth(), (float) (canvas.getHeight() / 2 + Constants.boundaryRectangleSize / 2), paint);
        // Bottom 3 rectangle of boundary selection
        canvas.drawRect(0, canvas.getHeight(), Constants.boundaryRectangleSize, (canvas.getHeight() - Constants.boundaryRectangleSize), paint);
        canvas.drawRect((float) (canvas.getWidth() / 2 - Constants.boundaryRectangleSize / 2), canvas.getHeight(), (float) (canvas.getWidth() / 2 + Constants.boundaryRectangleSize / 2), (canvas.getHeight() - Constants.boundaryRectangleSize), paint);
        canvas.drawRect((canvas.getWidth() - Constants.boundaryRectangleSize), canvas.getHeight(), canvas.getWidth(), (canvas.getHeight() - Constants.boundaryRectangleSize), paint);
    }
}
