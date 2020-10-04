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
  void shouldNotifyWhenLotIsFull() {
    final ParkingStatusNotifier parkingFullNotifierMock = mock(ParkingStatusNotifier.class);
    final ParkingStatusNotifier parkingAlmostFullNotifierMock = mock(ParkingStatusNotifier.class);

    final ParkingLot parkingLot = new ParkingLot(1);
    final Car car = new Car(12);

    parkingLot.addLotFullNotifier(parkingFullNotifierMock);
    parkingLot.addAlmostFilledNotifier(parkingAlmostFullNotifierMock);

    parkingLot.park(car);

    verify(parkingFullNotifierMock, times(1)).publish(ParkingLotStatus.FILLED);
    verifyNoMoreInteractions(parkingAlmostFullNotifierMock);
  }

  @Test
  void shouldNotifyWhenLotIsAlmostFull() {
    final ParkingStatusNotifier parkingFullNotifierMock = mock(ParkingStatusNotifier.class);
    final ParkingStatusNotifier parkingAlmostFullNotifierMock = mock(ParkingStatusNotifier.class);

    final ParkingLot parkingLot = new ParkingLot(5);
    final Car car1 = new Car(12);
    final Car car2 = new Car(13);
    final Car car3 = new Car(14);
    final Car car4 = new Car(15);

    parkingLot.addLotFullNotifier(parkingFullNotifierMock);
    parkingLot.addAlmostFilledNotifier(parkingAlmostFullNotifierMock);

    parkingLot.park(car1);
    parkingLot.park(car2);
    parkingLot.park(car3);
    parkingLot.park(car4);

    verify(parkingAlmostFullNotifierMock, times(1)).publish(ParkingLotStatus.ALMOST_FULL);
    verifyNoMoreInteractions(parkingFullNotifierMock);
  }

  @Test
  void shouldNotParkTheCarWhenLotIsFull() {
    final ParkingLot parkingLot = new ParkingLot(1);
    final Car car1 = new Car(12);
    final Car car2 = new Car(13);

    parkingLot.park(car1);

    assertFalse(parkingLot.park(car2));
  }
}
