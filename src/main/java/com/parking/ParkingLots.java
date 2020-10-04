package com.parking;

public class ParkingLots {
    private final int numberOfLots;
    private final ParkingLot[] parkingLots;
    private int currentLotId = 0;

    public ParkingLots(int numberOfLots, int lotSize) {
        this.numberOfLots = numberOfLots;
        this.parkingLots = this.createParkingLots(numberOfLots, lotSize);
    }

    private ParkingLot[] createParkingLots(int numberOfLots, int lotSize) {
        ParkingLot[] parkingLots = new ParkingLot[numberOfLots];

        for (int i = 0; i < numberOfLots; i++) {
            parkingLots[i] = new ParkingLot(lotSize);
            parkingLots[i].addEventListener(ParkingLotEvent.FULL, this::onParkingLotFull);
        }

        return parkingLots;
    }

    private void onParkingLotFull(ParkingEventInfo status) {
        this.currentLotId++;
    }

    public ParkingStatus park(Object car) {
        if (this.currentLotId >= this.numberOfLots) {
            return ParkingStatus.PARKING_FULL;
        }

        return this.parkingLots[this.currentLotId].park(car);
    }

    public void addListenerToAllLots(ParkingLotEvent event, ParkingLotListener parkingLotListener) {
        for (ParkingLot parkingLot : this.parkingLots) {
            parkingLot.addEventListener(event, parkingLotListener);
        }
    }
}
