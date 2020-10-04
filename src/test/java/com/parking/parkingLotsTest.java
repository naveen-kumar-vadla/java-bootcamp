package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class parkingLotsTest {

  @Test
  void shouldParkTheCarWhenSlotAvailable() {
    final ParkingLots parkingLots = new ParkingLots(1, 2);
    final Object car = new Object();

    assertTrue(parkingLots.park(car));
  }

  @Test
  void shouldNotParkTheCarWhenNoEmptySlots() {
    final ParkingLots parkingLots = new ParkingLots(1, 1);
    final Object car1 = new Object();
    final Object car2 = new Object();

    parkingLots.park(car1);
    assertFalse(parkingLots.park(car2));
  }

  @Test
  void shouldParkInNextParkingLotWhenCurrentOneIsFull() {
    final ParkingLots parkingLots = new ParkingLots(2, 1);
    final Object car1 = new Object();
    final Object car2 = new Object();

    parkingLots.park(car1);
    assertTrue(parkingLots.park(car2));
  }

}