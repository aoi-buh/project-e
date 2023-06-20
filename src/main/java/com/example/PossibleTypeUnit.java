package com.example;

import java.util.ArrayList;

public class PossibleTypeUnit {
    public final int x;
    public final int y;
    public ArrayList<UnitType> possibleTypes;

    public PossibleTypeUnit(int x, int y, ArrayList<UnitType> possibleTypes) {
        this.x = x;
        this.y = y;
        this.possibleTypes = possibleTypes;
    }
}
