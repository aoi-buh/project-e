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
        return this.world;
    }

    public Pair<ArrayList<ArrayList<Unit>>, InQuadrantCoordinates> getWorldQuadrant(int absoluteX, int absoluteY) {
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

        return new Pair(worldQuadrant, new InQuadrantCoordinates(x, y));     // Shouldn't cause actual problems as the types are currect.
    }

    public Unit getUnit(int absoluteX, int absoluteY) throws NoSuchElementException {
        Pair<ArrayList<ArrayList<Unit>>, InQuadrantCoordinates> tuple = this.getWorldQuadrant(absoluteX, absoluteY);

        ArrayList<ArrayList<Unit>> worldQuadrant = tuple.first;
        InQuadrantCoordinates coordinates = tuple.second;

        try {
            return worldQuadrant.
                get(coordinates.x).
                get(coordinates.y);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(
                String.format("Unit not found | absoluteX: %d | absolute Y: %d", absoluteX, absoluteY));
        }
    }

    public void setUnit(int absoluteX, int absoluteY, Unit unitToSetTo) {
        Pair<ArrayList<ArrayList<Unit>>, InQuadrantCoordinates> tuple = this.getWorldQuadrant(absoluteX, absoluteY);

        ArrayList<ArrayList<Unit>> worldQuadrant = tuple.first;
        InQuadrantCoordinates coordinates = tuple.second;

        try {
            worldQuadrant.
                get(coordinates.x).
                set(coordinates.y, unitToSetTo);

        } catch (IndexOutOfBoundsException e) {
            this.addNewUnit(worldQuadrant, coordinates.x, coordinates.y, unitToSetTo);
        }
    }

    private void addNewUnit(ArrayList<ArrayList<Unit>> quadrant, int relativeX, int relativeY, Unit unit) {

        while (quadrant.size() <= relativeX) {
            quadrant.add(new ArrayList<Unit>());
        }

        ArrayList<Unit> slice = quadrant.get(relativeX);

        while (slice.size() < relativeY) {
            slice.add(null);
        }

        slice.add(unit);
    }
}
