package com.nacho91.carioca.internal;

/**
 * Created by ignacio on 19/01/17.
 */

public class Vector2d {

    public float x;
    public float y;

    public Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(float num){
        x += num;
        y += num;
    }

    public void add(Vector2d vector){
        x += vector.x;
        y += vector.y;
    }
}
