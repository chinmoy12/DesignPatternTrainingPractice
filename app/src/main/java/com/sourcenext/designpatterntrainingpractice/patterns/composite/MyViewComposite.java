package com.sourcenext.designpatterntrainingpractice.patterns.composite;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.sourcenext.designpatterntrainingpractice.patterns.factory.MyView;

import java.util.ArrayList;
import java.util.List;

public class MyViewComposite extends MyView {

    private List<MyView> mMyViewsList = new ArrayList<MyView>();

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void setSelected(boolean flag) {

    }

    public MyViewComposite(Context context) {
        super(context);
    }

    public MyViewComposite(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewComposite(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addMyView(MyView myView){
        mMyViewsList.add(myView);
    }

    public void removeMyView(MyView myView){
        mMyViewsList.remove(myView);
    }

    public int getViewListsSize() {
        return mMyViewsList.size();
    }

    public MyView getViewFromList(int index) {
        return mMyViewsList.get(index);
    }

    public void clearAllMyView(){
        mMyViewsList.clear();
    }
}
