package com.parking;

public class Attendant {
  private final ParkingLots parkingLots;

  public Attendant(ParkingLots parkingLots) {
    this.parkingLots = parkingLots;
  }

  public boolean park(Object car) {
    return this.parkingLots.park(car);
  }

  public Assistant createAssistant() {
    return new Assistant(this.parkingLots);
  }
}
