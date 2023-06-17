package com.example;

public class GameLoop {
    
    private boolean exit;
    private boolean pause;
    private Pair<Integer, Integer> worldDimension;
    // private Pair<Integer, Integer> middle;
    private UnitType[][] world;


    public GameLoop(int worldWidth, int worldHeight) {
        this.exit = false;
        this.pause = true;
        this.worldDimension = new Pair<Integer,Integer>(worldWidth, worldHeight);
        // this.middle = new Pair<Integer,Integer>(worldWidth / 2, worldHeight / 2);
        this.world = new UnitType[worldWidth][worldHeight];

        this.loop();
    }

    private void loop() {
        while (pause) {};
        
        world[0][0] = UnitType.Land;

        for (int x = 1; x < worldDimension.first; x++) {
            for (int y = 0; y < worldDimension.second; y++) {
                
            }
        }






        if (exit) return;
        loop();
    }

    public void setPause(boolean shouldPause) {
        this.pause = shouldPause;
    }

    public boolean isPause() {
        return this.pause;
    }

    public String worldToString() {

        String output = "";

        for (int y = 0; y < worldDimension.second; y++) {
            for (int x = 0; x < worldDimension.first; x++) {
                output += String.format("|%-10s|", world[x][y].toString());
            }
            output += "\n";
        }

        return output;
    }
}
