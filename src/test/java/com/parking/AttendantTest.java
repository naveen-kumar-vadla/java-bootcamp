package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {

    @Test
    void shouldParkTheCar() {
        final ParkingLot[] lots = new ParkingLot[1];
        lots[0] = new ParkingLot(5);
        final ParkingLots parkingLots = ParkingLots.createParkingLots(lots);

        final Attendant attendant = new Attendant(parkingLots);
        final Object car = new Object();

        assertEquals(ParkingStatus.DONE, attendant.park(car));
    }

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