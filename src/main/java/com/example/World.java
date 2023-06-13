package com.example;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class World {
    
    private ArrayList<ArrayList<Unit>>[] world; 

    public World() {
        this.world = (ArrayList<ArrayList<Unit>>[]) new ArrayList[4];           // chatgpt solution https://chat.openai.com/share/2f10bbc4-b422-4efc-8a06-e103da839de2
        for (int i = 0; i < 4; i++) {
            this.world[i] = new ArrayList<>();
        }
    }

    public ArrayList<ArrayList<Unit>>[] getWorld() {
        return world;
    }

    public Tuple<ArrayList<ArrayList<Unit>>, RelativeCoordinates> getWorldQuadrant(int absoluteX, int absoluteY) {
        ArrayList<ArrayList<Unit>> worldQuadrant;

        int x = (absoluteX > -1) ? absoluteX : (absoluteX + 1) * -1;
        int y = (absoluteY > -1) ? absoluteY : (absoluteY + 1) * -1;

        if (absoluteX > -1 && absoluteY > -1) {
            worldQuadrant = this.world[0];
        }
        else if (absoluteX < 0 && absoluteY > -1) {
            worldQuadrant = this.world[1];
        }
        else if (absoluteX < 0 && absoluteY < 0) {
            worldQuadrant = this.world[2];
        }
        else {
            worldQuadrant = this.world[3];
        }

        return new Tuple(worldQuadrant, new RelativeCoordinates(x, y));     // Shouldn't cause actual problems as the types are currect.
    }

    public Unit getUnit(int absoluteX, int absoluteY) {
        Tuple<ArrayList<ArrayList<Unit>>, RelativeCoordinates> tuple = this.getWorldQuadrant(absoluteX, absoluteY);

        ArrayList<ArrayList<Unit>> worldQuadrant = tuple.first;
        RelativeCoordinates coordinates = tuple.second;

        Unit unit = worldQuadrant.
            get(coordinates.x).
            get(coordinates.y);
        
        if (unit == null) {
            throw new NoSuchElementException(
                String.format(
                    "Unit not found | absoluteX: %i | absolute Y: %i", absoluteX, absoluteY));
        }
        
        return unit;
    }

    public void setUnit(int absoluteX, int absoluteY, Unit unitToSetTo) {
        Tuple<ArrayList<ArrayList<Unit>>, RelativeCoordinates> tuple = this.getWorldQuadrant(absoluteX, absoluteY);

        ArrayList<ArrayList<Unit>> worldQuadrant = tuple.first;
        RelativeCoordinates coordinates = tuple.second;

        try {
            worldQuadrant.
                get(coordinates.x).
                set(coordinates.y, unitToSetTo);

        } catch (IndexOutOfBoundsException e) {
            for (;worldQuadrant.size() < coordinates.x;) {
                worldQuadrant.add(new ArrayList<Unit>());
            }
            for (;worldQuadrant.get(coordinates.x).size() < coordinates.y;) {
                if (worldQuadrant.get(coordinates.x).size() == coordinates.y) {
                    worldQuadrant.get(coordinates.x).add(unitToSetTo);
                    break;
                }
                worldQuadrant.get(coordinates.x).add(new Unit(0, 0));
            }
        }
        // worldQuadrant.get(coordinates.x).set(coordinates.y, unitToSetTo);
    }

    public void clear() {       // only for testing purposes
        for(ArrayList<ArrayList<Unit>> qudrant: this.world) {
            qudrant.clear();
        }
    }
}
