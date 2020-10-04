package com.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private final int size;
    private final Object[] parkingLot;
    private int currentSlotNumber = 0;
    private final HashMap<ParkingLotEvent, List<ParkingLotListener>> eventListeners = new HashMap<>();

    public ParkingLot(int size) {
        this.size = size;
        this.parkingLot = new Object[size];

        for (ParkingLotEvent event : ParkingLotEvent.values()) {
            this.eventListeners.put(event, new ArrayList<>());
        }
    }

    public boolean park(Object car) {
        if (this.isFull()) {
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

    private boolean isAlmostFull() {
        return ((this.currentSlotNumber / (double) this.size) * 100) == 80;
    }

    private void notifyObservers() {
        if (this.isFull()) {
            for (final ParkingLotListener listener : this.eventListeners.get(ParkingLotEvent.FULL)) {
                listener.listen(ParkingLotStatus.FULL);
            }

        }
        if (this.isAlmostFull()) {
            for (final ParkingLotListener listener : this.eventListeners.get(ParkingLotEvent.ALMOST_FULL)) {
                listener.listen(ParkingLotStatus.ALMOST_FULL);
            }
        }
    }

    public void addEventListener(ParkingLotEvent parkingLotEvent, ParkingLotListener listener) {
        this.eventListeners.get(parkingLotEvent).add(listener);
    }
}
