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

    public void div(double num){
        x /= num;
        y /= num;
    }

    public void div(Vector2d vector){
        x /= vector.x;
        y /= vector.y;
    }

    public void mult(double num){
        x *= num;
        y *= num;
    }

    public Vector2d copy(){
        return new Vector2d(x, y);
    }
}
