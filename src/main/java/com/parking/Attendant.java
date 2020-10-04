package com.parking;

public class Attendant {
  private final ParkingLots parkingLots;

  public Attendant(ParkingLots parkingLots) {
    this.parkingLots = parkingLots;
  }

  public boolean park(Car car) {
    return this.parkingLots.park(car);
  }

  public Attendant createAssistant() {
    return new Attendant(this.parkingLots);
  }
}
