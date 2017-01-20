package com.nacho91.carioca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ignacio on 18/01/17.
 */

public class CariocaView extends View {

    private Particle particle;
    private Particle particle2;
    private Particle particle3;

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
        particle = new Particle(100, 10, 0, 2, 150, 5, Color.RED);
        particle2 = new Particle(100, 110, 2, 2, 150, 5, Color.BLUE);
        particle3 = new Particle(100, 210, 2, 2, 150, 5, Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        particle.update();
        particle.render(canvas);

        particle2.update();
        particle2.render(canvas);


        particle3.update();
        particle3.render(canvas);

        ViewCompat.postInvalidateOnAnimation(this);
    }
}
