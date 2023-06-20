package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class GameLoop {
    
    public static final UnitType[] UNIT_TYPE_AS_ARRAY = UnitType.values();

    private boolean exit;
    private boolean pause;
    private int worldWidth;
    private int worldHeight;
    private UnitType[][] world;
    private ArrayList<PossibleTypeUnit> lowestUncertainty;


    public GameLoop(int worldWidth, int worldHeight) {
        this.exit = false;
        this.pause = false;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.world = new UnitType[worldWidth][worldHeight];
        this.lowestUncertainty = new ArrayList<PossibleTypeUnit>();

        for (UnitType[] slice: this.world) {
            Arrays.fill(slice, null);
        }
        
        int x = worldWidth / 2;
        int y = worldHeight / 2;

        world[x][y] = UnitType.GRASS_LAND;

        doForNeighbours(null, x, y, (input) -> {
            this.lowestUncertainty.add(
                new PossibleTypeUnit(input.second.first,
                            input.second.second,
                            possibleTypesToGenerate(input.second.first, input.second.second)));

        });

        this.loop();
    }

    private void loop() {
        while (pause) {
            if (exit) return;
        }
        
        // generate();

        
        System.out.println(worldToString());




        if (exit) return;
        loop();
    }

    private boolean generate() {

        int x, y;

        for (PossibleTypeUnit unit : this.lowestUncertainty) {
            x = unit.x;
            y = unit.y;




        }

        return true;
    }

    private ArrayList<UnitType> possibleTypesToGenerate(int x, int y) {

        ArrayList<UnitType> output = new ArrayList<UnitType>(Arrays.asList(UNIT_TYPE_AS_ARRAY));

        doForNeighbours(output, x, y, (input) -> {

            ArrayList<UnitType> innerOutput = (ArrayList<UnitType>) input.first;

            int neighbourX = input.second.first;
            int neighbourY = input.second.second;

            innerOutput.retainAll(Arrays.asList(possibleTypes(this.world[neighbourX][neighbourY])));        // solution from here: https://stackoverflow.com/a/5943349

        });

        return output;
    }

    private static UnitType[] possibleTypes(UnitType type) {
        // int i = Arrays.binarySearch(UNIT_TYPE_AS_ARRAY, type);
        if (type == null) {
            return UNIT_TYPE_AS_ARRAY;
        }
        int i = Arrays.asList(UNIT_TYPE_AS_ARRAY).indexOf(type);
        return new UnitType[] {UNIT_TYPE_AS_ARRAY[i - 1], type, UNIT_TYPE_AS_ARRAY[i + 1]};
    }

    private void doForNeighbours(Object container, int x, int y,
            Consumer<? super Pair<Object, Pair<Integer, Integer>>> action) {

        if (y - 1 > -1)
            action.accept(new Pair<Object, Pair<Integer, Integer>>(container, new Pair<Integer, Integer>(x, y - 1)));
        if (x + 1 < worldWidth)
            action.accept(new Pair<Object, Pair<Integer, Integer>>(container, new Pair<Integer, Integer>(x + 1, y)));
        if (y + 1 < worldHeight)
            action.accept(new Pair<Object, Pair<Integer, Integer>>(container, new Pair<Integer, Integer>(x, y + 1)));
        if (x - 1 > -1)
            action.accept(new Pair<Object, Pair<Integer, Integer>>(container, new Pair<Integer, Integer>(x - 1, y)));
    }

    public void setPause(boolean shouldPause) {
        this.pause = shouldPause;
    }

    public boolean isPause() {
        return this.pause;
    }

    public String worldToString() {

        String output = "";
        UnitType unit;

        for (int y = 0; y < worldHeight; y++) {
            for (int x = 0; x < worldWidth; x++) {

                unit = world[x][y];
                
                if (unit == null) {
                    output += "|            |";
                    continue;
                }

                output += String.format("|%-12s|", unit.toString());
            }
            output += "\n";
        }

        return output;
    }
}
