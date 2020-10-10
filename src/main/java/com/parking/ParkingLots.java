package com.parking;

public class ParkingLots {
    private final ParkingLot[] lots;
    private int currentLotId = 0;

    private ParkingLots(ParkingLot[] lots) {
        this.lots = lots;
    }

    public static ParkingLots createParkingLots(ParkingLot[] lots) {
        final ParkingLots parkingLots = new ParkingLots(lots);
        parkingLots.setLotFullListener();

        return parkingLots;
    }

    private void setLotFullListener() {
        this.addListenerToAllLots(ParkingLotEvent.FULL, this::onParkingLotFull);
    }

    private void onParkingLotFull(ParkingEventInfo parkingEventInfo) {
        this.currentLotId++;
    }

    public ParkingStatus park(Object car) {
        if (this.currentLotId >= this.lots.length) {
            return ParkingStatus.NOT_DONE;
        }

        return this.lots[this.currentLotId].park(car) == -1 ? ParkingStatus.NOT_DONE : ParkingStatus.DONE;
    }

    public void addListenerToAllLots(ParkingLotEvent event, ParkingLotListener parkingLotListener) {
        for (ParkingLot parkingLot : this.lots) {
            parkingLot.addEventListener(event, parkingLotListener);
        }
    }
}
