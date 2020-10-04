package com.parking;

public class ParkingLots {
  private final int numberOfLots;
  private final int lotSize;
  private ParkingLot[] parkingLots;
  private int currentLotId = 0;

  public ParkingLots(int numberOfLots, int lotSize) {
    this.numberOfLots = numberOfLots;
    this.lotSize = lotSize;
    this.parkingLots = this.createParkingLots(numberOfLots, lotSize);
  }

  private ParkingLot[] createParkingLots(int numberOfLots, int lotSize) {
    ParkingLot[] parkingLots = new ParkingLot[numberOfLots];

    for(int i = 0; i < numberOfLots; i++) {
      parkingLots[i] = new ParkingLot(lotSize);
      parkingLots[i].addLotFullNotifier(this::incCurrentLotId);
    }

    return parkingLots;
  }

  private void incCurrentLotId(ParkingLotStatus status) {
    this.currentLotId++;
  }

  public boolean park(Car car) {
    if(this.currentLotId >= this.numberOfLots) {
      return false;
    }

    return this.parkingLots[this.currentLotId].park(car);
  }
}
