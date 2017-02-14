package com.nacho91.carioca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.nacho91.carioca.internal.Vector2d;

/**
 * Created by ignacio on 18/01/17.
 */

public class CariocaView extends View {

    private Particle particle;
    private Particle particle2;
    private Particle particle3;

    private  Vector2d gravity;

    private ParticleSystem system;

    public CariocaView(Context context) {
        this(context, null);
    }

    public CariocaView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CariocaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        Vector2d origin = new Vector2d(300, 300);


        Vector2d wind = new Vector2d(0.01f,0);
        gravity = new Vector2d(0,0.1f);

        particle = new Particle(100, 10, 0, 2, 150, 5, Color.RED);
        particle.applyForce(wind);
        particle.applyForce(gravity);

        particle2 = new Particle(100, 110, 2, 2, 150, 5, Color.BLUE);
        particle2.applyForce(wind);
        particle2.applyForce(gravity);

        particle3 = new Particle(100, 210, 2, 2, 150, 5, Color.GREEN);
        particle3.applyForce(wind);
        particle3.applyForce(gravity);

        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Vector2d size = new Vector2d(w, h);

        system = new ParticleSystem(5, size);

    }

    private long startTime;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        system.applyForce(gravity);

        if(System.currentTimeMillis() - startTime > 100) {
            system.addParticle();
            startTime = System.currentTimeMillis();
        }
        system.run(canvas);

//        particle.update();
//        particle.render(canvas);
//
//        particle2.update();
//        particle2.render(canvas);
//
//
//        particle3.update();
//        particle3.render(canvas);

        ViewCompat.postInvalidateOnAnimation(this);
    }
}
