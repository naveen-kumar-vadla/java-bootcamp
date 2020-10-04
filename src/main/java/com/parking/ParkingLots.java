package com.parking;

public class ParkingLots {
    private final ParkingLot[] lots;
    private int currentLotId = 0;

    private ParkingLots(ParkingLot[] lots) {
        this.lots = lots;
        this.initializeLots();
    }

    private void initializeLots() {
        for (ParkingLot lot : this.lots) {
            lot.addEventListener(ParkingLotEvent.FULL, this::onParkingLotFull);
        }
    }

    private void onParkingLotFull(ParkingEventInfo parkingEventInfo) {
        this.currentLotId++;
    }

    public ParkingStatus park(Object car) {
        if (this.currentLotId >= this.lots.length) {
            return ParkingStatus.PARKING_FULL;
        }

        return this.lots[this.currentLotId].park(car);
    }

    public void addListenerToAllLots(ParkingLotEvent event, ParkingLotListener parkingLotListener) {
        for (ParkingLot parkingLot : this.lots) {
            parkingLot.addEventListener(event, parkingLotListener);
        }
    }

    public static ParkingLots createParkingLots(ParkingLot[] lots) {
        return new ParkingLots(lots);
    }
}
