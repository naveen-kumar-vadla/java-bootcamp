package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {

    @Test
    void shouldCreateAnAssistantWithSameParkingLots() {
        final ParkingLot[] lots = new ParkingLot[2];
        lots[0] = new ParkingLot(5);
        lots[1] = new ParkingLot(2);
        final ParkingLots parkingLots = ParkingLots.createParkingLots(lots);

        final Attendant attendant = new Attendant(parkingLots);

        assertEquals(new Assistant(parkingLots), attendant.createAssistant());
    }
}