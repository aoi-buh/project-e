// package com.example;

// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.NoSuchElementException;

// public class WorldToString {

//     public static String toString(World worldToString) {
//         String output = new String();
//         ArrayList<ArrayList<Unit>>[] world = worldToString.getWorld();


//         ArrayList<ArrayList<Unit>> quadrant1 = world[0];
//         ArrayList<ArrayList<Unit>> quadrant2 = world[1];
//         ArrayList<ArrayList<Unit>> quadrant3 = world[2];
//         ArrayList<ArrayList<Unit>> quadrant4 = world[3];

//         final int LOWEST_X = lowestX(worldToString);
//         final int HIGHTEST_Y = highestY(worldToString);

//         for (int y = HIGHTEST_Y; y > -1; y--) {
//             for (int x = LOWEST_X; x < 0; x++) {
//                 try {
//                     output += worldToString.getUnit(x, y).toStringAsInt();
//                 } catch (NoSuchElementException e) {
//                     output += 
//                 }
//             }

//             for (int x = 0; x < quadrant1.size(); x++) {
//                 try {

//                 } catch (NoSuchElementException e) {

//                 }
//             }
//             output += "\n";
//         }
        





        

//         return output;
//     }

//     private static int lowestX(World world) {

//         ArrayList<ArrayList<Unit>> quadrant2 = world.getWorld()[1];
//         ArrayList<ArrayList<Unit>> quadrant3 = world.getWorld()[2];

//         if (quadrant2.size() > quadrant3.size()) {
//             return -1 * quadrant2.size();
//         }

//         return quadrant3.size();
//     }

//     private static int highestX(World world) {

//         ArrayList<ArrayList<Unit>> quadrant1 = world.getWorld()[0];
//         ArrayList<ArrayList<Unit>> quadrant4 = world.getWorld()[3];

//         return (quadrant1.size() > quadrant4.size()) ? quadrant1.size() : quadrant4.size();
//     }
    
//     private static int highestY(World world) {

//         Iterator<ArrayList<Unit>> quadrant1Iterator = world.getWorld()[0].iterator();
//         Iterator<ArrayList<Unit>> quadrant2Iterator = world.getWorld()[2].iterator();

//         int highestY1 = -1;
//         int highestY2 = -1;

//         while (quadrant1Iterator.hasNext()) {
//             ArrayList<Unit> slice = quadrant1Iterator.next();
//             if (slice.size() - 1 > highestY1) {
//                 highestY1 = slice.size() - 1;
//             }
//         }

//         while (quadrant2Iterator.hasNext()) {
//             ArrayList<Unit> slice = quadrant2Iterator.next();
//             if (slice.size() - 1 > highestY2) {
//                 highestY2 = slice.size() - 1;
//             }
//         }
       
//         return (highestY1 > highestY2) ? highestY1 : highestY2;
//     }
// }
