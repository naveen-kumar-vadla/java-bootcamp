package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ParkingLotTest {

    @Test
    void shouldParkTheCar() {
        final ParkingLot parkingLot = new ParkingLot(2);
        final Car car = new Car(12);

        assertTrue(parkingLot.park(car));
    }

    @Test
    void shouldNotParkTheCarWhenLotIsFull() {
        final ParkingLot parkingLot = new ParkingLot(1);
        final Car car1 = new Car(12);
        final Car car2 = new Car(13);

        parkingLot.park(car1);

        assertFalse(parkingLot.park(car2));
    }

    @Test
    void shouldNotifyWhenLotIsFull() {
        final ParkingLotListener parkingLotListener1 = mock(ParkingLotListener.class);
        final ParkingLotListener parkingLotListener2 = mock(ParkingLotListener.class);

        final ParkingLot parkingLot = new ParkingLot(2);
        final Car car = new Car(12);

        parkingLot.addEventListener(ParkingLotEvent.FULL, parkingLotListener1);
        parkingLot.addEventListener(ParkingLotEvent.FULL, parkingLotListener2);

        parkingLot.park(car);
        parkingLot.park(car);

        verify(parkingLotListener1).listen(ParkingLotStatus.FULL);
        verify(parkingLotListener2).listen(ParkingLotStatus.FULL);
    }

    @Test
    void shouldNotifyWhenLotIsAlmostFull() {
        final ParkingLotListener parkingLotListener1 = mock(ParkingLotListener.class);
        final ParkingLotListener parkingLotListener2 = mock(ParkingLotListener.class);

        final ParkingLot parkingLot = new ParkingLot(5);
        final Car car1 = new Car(12);
        final Car car2 = new Car(13);
        final Car car3 = new Car(14);
        final Car car4 = new Car(15);

        parkingLot.addEventListener(ParkingLotEvent.ALMOST_FULL, parkingLotListener1);
        parkingLot.addEventListener(ParkingLotEvent.ALMOST_FULL, parkingLotListener2);

        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.park(car3);
        parkingLot.park(car4);

        verify(parkingLotListener1).listen(ParkingLotStatus.ALMOST_FULL);
        verify(parkingLotListener2).listen(ParkingLotStatus.ALMOST_FULL);
    }
}
