package com.nacho91.carioca;

import android.graphics.Canvas;
import android.graphics.Color;

import com.nacho91.carioca.internal.Vector2d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ignacio on 4/2/2017.
 */

public class ParticleSystem {

    List<Particle> particles;    // An arraylist for all the particles
    Vector2d size;        // An origin point for where particles are birthed

    ParticleSystem(int num, Vector2d v) {
        particles = new ArrayList<>();   // Initialize the arraylist
        size = v.copy();                        // Store the origin point
//        for (int i = 0; i < num; i++) {
//
//            float dx = Utils.randInt(-1, 1);
//            float dy = Utils.randInt(2, 0);
//
//
//            Random rnd = new Random();
//            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//
//            particles.add(new Particle((int)origin.x, (int)origin.y, dx, dy, 150, 255, color));    // Add "num" amount of particles to the arraylist
//        }
    }

    void run(Canvas canvas) {
        // Using the Iterator b/c we are deleting from list while iterating
        Iterator<Particle> it = particles.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            p.render(canvas);
            if (p.update()) {
                it.remove();
            }
        }
    }

    void addParticle() {

        int originX = (int) Utils.randInt(0, size.x);
        int originY = 0;

        float dx = Utils.randInt(-1, 1);
        float dy = Utils.randInt(2, 0);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        particles.add(new Particle(originX, originY, dx, dy, 150, 255, color));
    }

    void applyForce(Vector2d f) {
        for (Particle p: particles) {
            p.applyForce(f);
        }
    }

    void addParticle(Particle p) {
        particles.add(p);
    }
}
