package com.example;

public enum UnitType {
    Water(0.7f, 0.3f),
    Land(0.3f, 0.7f);

    public final float[] probability;

    private UnitType(float... probability) {
        validation(probability);
        this.probability = probability;


    }

    private static boolean validation(float[] probability) {
        if (probability.length != UnitType.values().length) {
            return false;
        }

        float tempSum = 0;
        for (float temp: probability) {
            tempSum += temp;
        }

        if (tempSum != 1) {
            return false;
        }
        return true;
    }
}
