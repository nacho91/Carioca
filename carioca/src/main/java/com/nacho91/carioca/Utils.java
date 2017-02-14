package com.nacho91.carioca;

import java.util.Random;

/**
 * Created by Ignacio on 5/2/2017.
 */

public class Utils {

    public static float randInt(float min, float max) {

        Random rand = new Random();

        return (float) (rand.nextGaussian() * (max - min) + min);
    }
}
