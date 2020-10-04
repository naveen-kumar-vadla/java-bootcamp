package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssistantTest {

    @Test
    void shouldParkACar() {
        final ParkingLot[] lots = new ParkingLot[1];
        lots[0] = new ParkingLot(5);
        final ParkingLots parkingLots = ParkingLots.createParkingLots(lots);

        final Assistant assistant = new Assistant(parkingLots);
        final Object car = new Object();

        assertEquals(ParkingStatus.DONE, assistant.park(car));
    }
}