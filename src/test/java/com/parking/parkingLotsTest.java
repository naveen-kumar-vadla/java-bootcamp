package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class parkingLotsTest {

  @Test
  void shouldParkTheCarWhenSlotAvailable() {
    final ParkingLots parkingLots = new ParkingLots(1, 2);
    final Car car = new Car(12);

    assertTrue(parkingLots.park(car));
  }

  @Test
  void shouldNotParkTheCarWhenNoEmptySlots() {
    final ParkingLots parkingLots = new ParkingLots(1, 1);
    final Car car1 = new Car(12);
    final Car car2 = new Car(12);

    parkingLots.park(car1);
    assertFalse(parkingLots.park(car2));
  }

  @Test
  void shouldParkInNextParkingLotWhenCurrentOneIsFull() {
    final ParkingLots parkingLots = new ParkingLots(2, 1);
    final Car car1 = new Car(12);
    final Car car2 = new Car(12);

    parkingLots.park(car1);
    assertTrue(parkingLots.park(car2));
  }

}