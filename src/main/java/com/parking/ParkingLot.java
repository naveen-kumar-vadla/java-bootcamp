package com.parking;

import java.util.ArrayList;

public class ParkingLot {
  private final int size;
  private ArrayList <ParkingStatusNotifier> parkingFullNotifiers = new ArrayList <>();
  private ArrayList <ParkingStatusNotifier> parkingAlmostFullNotifiers = new ArrayList <>();
  private final Car[] parkingLot;
  private int currentSlotNumber = 0;

  public ParkingLot(int size) {
    this.size = size;
    this.parkingLot = new Car[size];
  }

  public boolean park(Car car) {
    if(this.isFull()) {
      return false;
    }

    this.parkingLot[this.currentSlotNumber] = car;
    this.currentSlotNumber++;

    this.notifyObservers();

    return true;
  }

  private boolean isFull() {
    return this.currentSlotNumber >= this.size;
  }

  private void notifyObservers() {
    if(this.isFull()) {
      for(final ParkingStatusNotifier notifier : this.parkingFullNotifiers) {
        notifier.publish(ParkingLotStatus.FILLED);
      }

    }
    if(isAlmostFull()) {
      for(final ParkingStatusNotifier notifier : this.parkingAlmostFullNotifiers) {
        notifier.publish(ParkingLotStatus.ALMOST_FULL);
      }
    }
  }

  private boolean isAlmostFull() {
    return ((this.currentSlotNumber / (double) this.size) * 100) == 80;
  }

  public boolean addAlmostFilledNotifier(final ParkingStatusNotifier parkingAlmostFullNotifier) {
    return this.parkingAlmostFullNotifiers.add(parkingAlmostFullNotifier);
  }

  public boolean addLotFullNotifier(final ParkingStatusNotifier parkingFullNotifier) {
    return this.parkingFullNotifiers.add(parkingFullNotifier);
  }
}
