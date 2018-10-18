package com.manu.animatordemo.samples;

/**
 * Powered by jzman.
 * Created on 2018/9/25 0025.
 */
public class Point {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
