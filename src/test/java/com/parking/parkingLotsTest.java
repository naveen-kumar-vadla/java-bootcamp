package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class parkingLotsTest {

    @Test
    void shouldParkTheCarWhenSlotAvailable() {
        final ParkingLot[] lots = new ParkingLot[1];
        lots[0] = new ParkingLot(1);

        final ParkingLots parkingLots = ParkingLots.createParkingLots(lots);
        final Object car = new Object();

        assertEquals(ParkingStatus.DONE, parkingLots.park(car));
    }

    @Test
    void shouldNotParkTheCarWhenNoEmptySlots() {
        final ParkingLot[] lots = new ParkingLot[1];
        lots[0] = new ParkingLot(1);

        final ParkingLots parkingLots = ParkingLots.createParkingLots(lots);
        final Object car1 = new Object();
        final Object car2 = new Object();

        parkingLots.park(car1);

        assertEquals(ParkingStatus.NOT_DONE, parkingLots.park(car2));
    }

    @Test
    void shouldParkInNextParkingLotWhenCurrentOneIsFull() {
        final ParkingLot[] lots = new ParkingLot[2];
        lots[0] = new ParkingLot(1);
        lots[1] = new ParkingLot(1);

        final ParkingLots parkingLots = ParkingLots.createParkingLots(lots);
        final Object car1 = new Object();
        final Object car2 = new Object();

        parkingLots.park(car1);

        assertEquals(ParkingStatus.DONE, parkingLots.park(car2));
    }

    @Test
    void shouldInvokeListenersAccordingToEvents() {
        final ParkingLotListener parkingLotListener = mock(ParkingLotListener.class);

        final ParkingLot[] lots = new ParkingLot[1];
        lots[0] = new ParkingLot(5);

        final ParkingLots parkingLots = ParkingLots.createParkingLots(lots);
        final Object car = new Object();

        parkingLots.addListenerToAllLots(ParkingLotEvent.ALMOST_FULL, parkingLotListener);

        parkingLots.park(car);
        parkingLots.park(car);
        parkingLots.park(car);
        parkingLots.park(car);
        parkingLots.park(car);

        final ParkingEventInfo expectedParkingEventInfo = new ParkingEventInfo(5, 1, ParkingLotEvent.ALMOST_FULL);

        verify(parkingLotListener).handleParked(expectedParkingEventInfo);
    }
}