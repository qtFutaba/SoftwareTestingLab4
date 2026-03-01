package com.baarsch_bytes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DrinkingTest {

    @Test
    void testDrinkingAgeIsOver21 () {
        Drinking drinking = new Drinking();

        boolean result = drinking.canIDrink(30);
        assertTrue(result, "If Age is at or over 21, then Can I Drink returns true");

    }

    @Test
    void testDrinkingAgeIsNotOver21 () {
        Drinking drinking = new Drinking();

        boolean result = drinking.canIDrink(10);
        assertFalse(result, "If Age is below 21, then Can I Drink returns false");

    }


}
