package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlotsTest {

    @Test
    void shouldAddTheCarWhenSlotAvailable() {
        final Slots slots = new Slots(2);
        final Object car = new Object();
        final int expectedSlotId = 0;
        
        assertEquals(expectedSlotId, slots.addCar(car));
    }

    @Test
    void shouldNotAddTheCarWhenSlotNotAvailable() {
        final Slots slots = new Slots(1);
        final Object car = new Object();
        final int expectedSlotId = -1;

        slots.addCar(car);

        assertEquals(expectedSlotId, slots.addCar(car));
    }

    @Test
    void shouldRemoveTheCarForAValidID() {

    }
}
