package com.sourcenext.designpatterntrainingpractice.listeners;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyView;

public class MoveViewTouchListener implements View.OnTouchListener {
    private GestureDetector mGestureDetector;
    private MyView mView;
    public MoveViewTouchListener(MyView view) {
        mGestureDetector = new GestureDetector(view.getContext(), mGestureListener);
        mView = view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mView.setSelected(true);

        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                mView.getLayoutParams().width = x;
                mView.getLayoutParams().height = y;
                mView.requestLayout();
                break;
        }
        return mGestureDetector.onTouchEvent(event);
    }

    private GestureDetector.OnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {
        private float mMotionDownX, mMotionDownY;

        @Override
        public boolean onDown(MotionEvent e) {
            mMotionDownX = e.getRawX() - mView.getTranslationX();
            mMotionDownY = e.getRawY() - mView.getTranslationY();
            mView.notifyAllObservers(mView, mView.getX(), mView.getY(), mView.getWidth(), mView.getHeight());
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            mView.setTranslationX(e2.getRawX() - mMotionDownX);
            mView.setTranslationY(e2.getRawY() - mMotionDownY);
            mView.notifyAllObservers(mView, mView.getX(), mView.getY(), mView.getWidth(), mView.getHeight());
            return true;
        }
    };
}
