package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class parkingLotsTest {

    @Test
    void shouldParkTheCarWhenSlotAvailable() {
        final ParkingLots parkingLots = new ParkingLots(1, 2);
        final Object car = new Object();

        assertEquals(ParkingStatus.DONE, parkingLots.park(car));
    }

    @Test
    void shouldNotParkTheCarWhenNoEmptySlots() {
        final ParkingLots parkingLots = new ParkingLots(1, 1);
        final Object car1 = new Object();
        final Object car2 = new Object();

        parkingLots.park(car1);

        assertEquals(ParkingStatus.PARKING_FULL, parkingLots.park(car2));
    }

    @Test
    void shouldParkInNextParkingLotWhenCurrentOneIsFull() {
        final ParkingLots parkingLots = new ParkingLots(2, 1);
        final Object car1 = new Object();
        final Object car2 = new Object();

        parkingLots.park(car1);

        assertEquals(ParkingStatus.DONE, parkingLots.park(car2));
    }

    @Test
    void shouldInvokeListenersAccordingToEvents() {
        final ParkingLotListener parkingLotListener1 = mock(ParkingLotListener.class);
        final ParkingLotListener parkingLotListener2 = mock(ParkingLotListener.class);

        final ParkingLots parkingLots = new ParkingLots(2, 5);
        final Object car = new Object();

        parkingLots.addListenerToAllLots(ParkingLotEvent.FULL, parkingLotListener1);
        parkingLots.addListenerToAllLots(ParkingLotEvent.ALMOST_FULL, parkingLotListener2);

        parkingLots.park(car);
        parkingLots.park(car);
        parkingLots.park(car);
        parkingLots.park(car);
        parkingLots.park(car);

        final ParkingEventInfo expectedParkingEventInfo1 = new ParkingEventInfo(5, 0, ParkingLotEvent.FULL);
        final ParkingEventInfo expectedParkingEventInfo2 = new ParkingEventInfo(5, 1, ParkingLotEvent.ALMOST_FULL);

        verify(parkingLotListener1).publishEvent(expectedParkingEventInfo1);
        verify(parkingLotListener2).publishEvent(expectedParkingEventInfo2);
    }
}