package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ParkingLotTest {

    @Test
    void shouldParkTheCar() {
        final ParkingLot parkingLot = new ParkingLot(2);
        final Object car = new Object();

        final int expectedSlotID = 0;
        assertEquals(expectedSlotID, parkingLot.park(car));
    }

    @Test
    void shouldNotParkTheCarWhenLotIsFull() {
        final ParkingLot parkingLot = new ParkingLot(1);
        final Object car1 = new Object();
        final Object car2 = new Object();

        parkingLot.park(car1);

        final int expectedSlotID = -1;
        assertEquals(expectedSlotID, parkingLot.park(car2));
    }

    @Test
    void shouldUnParkTheCarForValidID() {
        final ParkingLot parkingLot = new ParkingLot(2);
        final Object car = new Object();

        final int slotID = parkingLot.park(car);
        assertEquals(car, parkingLot.unPark(slotID));
    }

    @Test
    void shouldNotifyWhenLotIsFull() {
        final ParkingLotListener parkingLotListener1 = mock(ParkingLotListener.class);
        final ParkingLotListener parkingLotListener2 = mock(ParkingLotListener.class);

        final ParkingLot parkingLot = new ParkingLot(2);
        final Object car = new Object();

        parkingLot.addEventListener(ParkingLotEvent.FULL, parkingLotListener1);
        parkingLot.addEventListener(ParkingLotEvent.FULL, parkingLotListener2);

        parkingLot.park(car);
        parkingLot.park(car);

        final ParkingEventInfo expectedParkingEventInfo = new ParkingEventInfo(2, 0, ParkingLotEvent.FULL);

        verify(parkingLotListener1).handleParked(expectedParkingEventInfo);
        verify(parkingLotListener2).handleParked(expectedParkingEventInfo);
    }

    @Test
    void shouldNotifyWhenLotIsAlmostFull() {
        final ParkingLotListener parkingLotListener1 = mock(ParkingLotListener.class);
        final ParkingLotListener parkingLotListener2 = mock(ParkingLotListener.class);

        final ParkingLot parkingLot = new ParkingLot(5);
        final Object car1 = new Object();
        final Object car2 = new Object();
        final Object car3 = new Object();
        final Object car4 = new Object();

        parkingLot.addEventListener(ParkingLotEvent.ALMOST_FULL, parkingLotListener1);
        parkingLot.addEventListener(ParkingLotEvent.ALMOST_FULL, parkingLotListener2);

        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.park(car3);
        parkingLot.park(car4);

        final ParkingEventInfo expectedParkingEventInfo = new ParkingEventInfo(5, 1, ParkingLotEvent.ALMOST_FULL);

        verify(parkingLotListener1).handleParked(expectedParkingEventInfo);
        verify(parkingLotListener2).handleParked(expectedParkingEventInfo);
    }

    @Test
    void shouldNotifyWhenLotIsAlmostEmpty() {
        final ParkingLotListener parkingLotListener1 = mock(ParkingLotListener.class);
        final ParkingLotListener parkingLotListener2 = mock(ParkingLotListener.class);

        final ParkingLot parkingLot = new ParkingLot(5);
        final Object car1 = new Object();
        final Object car2 = new Object();

        parkingLot.addEventListener(ParkingLotEvent.ALMOST_EMPTY, parkingLotListener1);
        parkingLot.addEventListener(ParkingLotEvent.ALMOST_EMPTY, parkingLotListener2);

        final int slotID1 = parkingLot.park(car1);
        parkingLot.park(car2);

        final ParkingEventInfo expectedParkingEventInfo = new ParkingEventInfo(5, 4, ParkingLotEvent.ALMOST_EMPTY);

        parkingLot.unPark(slotID1);

        verify(parkingLotListener1).handleParked(expectedParkingEventInfo);
        verify(parkingLotListener2).handleParked(expectedParkingEventInfo);
    }
}
