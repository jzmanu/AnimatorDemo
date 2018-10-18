package com.manu.animatordemo.samples;

import android.animation.TypeEvaluator;

/**
 * Powered by jzman.
 * Created on 2018/9/25 0025.
 */
public class SineTypeValue implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        //y = sinA
        float distance = fraction * (endValue.getX() - startValue.getX());
        float x = startValue.getX() + distance;
        float y = startValue.getY() + (float) Math.sin(distance / 100 * Math.PI) * 100;
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        return point;
    }
}
