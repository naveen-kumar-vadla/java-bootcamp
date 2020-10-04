package com.parking;

public interface ParkingStatusNotifier {
  void publish(ParkingLotStatus parkingLotStatus);
}
