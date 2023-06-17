package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class WorldTest { 

    static final Unit zero = new Unit(0, 0);
    static final Unit one = new Unit(1, 1);
    static final Unit two = new Unit(2, 2);
    static final Unit three = new Unit(3, 3);
    static final Unit four = new Unit(4, 4);

    static final Unit[][] testGetQudrantTemplate = {{one , zero},
                                                    {two , three}};

    static final Unit[][] testSetAndGetTemplate = {{zero, zero, zero, zero, zero, zero},
                                                   {zero, zero, zero, zero, null, zero},
                                                   {zero, zero, zero, zero, zero, zero},
                                                   {zero, zero, zero, zero, zero, zero},
                                                   {zero, zero, one , zero, zero, zero},
                                                   {zero, zero, zero, zero, zero, zero}};
    

    // @Test
    // public void testAddNewUnit() {
    //     World testWorld = new World();


    // }

    @Test
    public void testGetQudrant() {
        World testWorld = new World();

        testWorld.setUnit(0, 0, zero);
        testWorld.setUnit(-1, 0, one);
        testWorld.setUnit(-1, -1, two);
        testWorld.setUnit(0, -1, three);

        assertEquals(zero,  testWorld.getWorldQuadrant(0, 0).first.get(0).get(0));
        assertEquals(one,   testWorld.getWorldQuadrant(-1, 0).first.get(0).get(0));
        assertEquals(two,   testWorld.getWorldQuadrant(-1, -1).first.get(0).get(0));
        assertEquals(three, testWorld.getWorldQuadrant(0, -1).first.get(0).get(0));
    }


    @Test
    public void testSetAndGet() {
        World testWorld = new World();

        // for (int y = 0; y < testSetAndGetTemplate.length; y++) {
        //     for (int x = 0; x < testSetAndGetTemplate[0].length; x++) {
        //         testWorld.setUnit(x - 3, y - 3, testSetAndGetTemplate[y][x]);
        //     }
        // }

        testWorld.setUnit(0, 0, new Unit(0, 0));
        testWorld.setUnit(1, 1, new Unit(1, 1));
        testWorld.setUnit(0, 0, four);

        // for (int y = 0; y < testSetAndGetTemplate.length; y++) {
        //     for (int x = 0; x < testSetAndGetTemplate[0].length; x++) {
        //         assertEquals(testWorld.getUnit(x - 3, y - 3), testSetAndGetTemplate[y][x]);
        //     }
        // }
    }
}
