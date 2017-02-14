package com.nacho91.carioca;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.nacho91.carioca.internal.Vector2d;

/**
 * Created by ignacio on 18/01/17.
 */

public class Particle {

    private Vector2d position;
    private Vector2d velocity;
    private Vector2d acceleration;
    private int size;
    private int life;
    private Paint paint;
    private float angle = 0;
    private float aVelocity = 0;
    private float aAcceleration = 0.001F;
    private float mass;

    public Particle(int x, int y, float dx, float dy, int size, int life, int color) {
        this.position = new Vector2d(x, y);
        this.velocity = new Vector2d(dx, dy);
        this.acceleration = new Vector2d(0, 0.05f);
        this.mass = 1;
        this.size = size;
        this.life = life;
        this.paint = new Paint();
        this.paint.setStrokeWidth(30);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(Paint.Cap.BUTT);
        this.paint.setColor(color);
    }

    public void applyForce(Vector2d force){
        Vector2d f = force.copy();
        f.div(mass);
        acceleration.add(f);
    }

    public boolean update(){
        velocity.add(acceleration);
        position.add(velocity);
        aVelocity += aAcceleration;
        angle += aVelocity;

        life--;

        acceleration.mult(0);

        return life <= 0;
    }

    public void render(Canvas canvas){
        RectF rect = new RectF(position.x-(size/2), position.y-(size/2), position.x+(size/2), position.y+(size/2));

        canvas.save();

        canvas.rotate(angle, position.x, position.y);
        canvas.drawArc(rect, 195, 40, false, paint);

        canvas.restore();
    }


}
