package com.example;

public class InQuadrantCoordinates {
    public final int x;
    public final int y;

    public InQuadrantCoordinates(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x value for InQuadrantCoordinates must be positive");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y value for InQuadrantCoordinates must be positive");
        }
        this.x = x;
        this.y = y;
    }
}
