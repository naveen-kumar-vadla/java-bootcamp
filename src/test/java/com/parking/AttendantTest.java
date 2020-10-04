package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {

    @Test
    void shouldCreateAnAssistantWithSameParkingLots() {
        final ParkingLots parkingLots = new ParkingLots(2, 10);
        final Attendant attendant = new Attendant(parkingLots);

        assertEquals(new Assistant(parkingLots), attendant.createAssistant());
    }
}