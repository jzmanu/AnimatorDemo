package com.manu.animatordemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Powered by jzman.
 * Created on 2018/9/25 0025.
 */
public class CycleView extends View{
    Paint mPaint;

    public CycleView(Context context) {
        super(context,null);
    }

    public CycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public CycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCycleView();
    }

    private void initCycleView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         canvas.drawCircle(100,100,50,mPaint);
    }
}
