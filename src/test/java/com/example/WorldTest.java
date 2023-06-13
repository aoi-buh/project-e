package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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

    static World testWorld = new World();
    
    @Test
    public void testGetQudrant() {
        testWorld.clear();

        for (int y = 0; y < testGetQudrantTemplate.length; y++) {
            for (int x = 0; x < testGetQudrantTemplate[0].length; x++) {
                testWorld.setUnit(x - 1, y - 1, testGetQudrantTemplate[y][x]);
            }
        }

        assertEquals(zero,  testWorld.getWorldQuadrant(0, 0).first.get(0).get(0));
        assertEquals(one,   testWorld.getWorldQuadrant(-1, 0).first.get(0).get(0));
        assertEquals(two,   testWorld.getWorldQuadrant(-1, -1).first.get(0).get(0));
        assertEquals(three, testWorld.getWorldQuadrant(0, -1).first.get(0).get(0));
    }


    @Test
    public void testSetAndGet() {
        testWorld.clear();

        for (int y = 0; y < testSetAndGetTemplate.length; y++) {
            for (int x = 0; x < testSetAndGetTemplate[0].length; x++) {
                testWorld.setUnit(x - 3, y - 3, testSetAndGetTemplate[y][x]);
            }
        }

        for (int y = 0; y < testSetAndGetTemplate.length; y++) {
            for (int x = 0; x < testSetAndGetTemplate[0].length; x++) {
                assertEquals(testWorld.getUnit(x - 3, y - 3), testSetAndGetTemplate[y][x]);
            }
        }
    }
}
