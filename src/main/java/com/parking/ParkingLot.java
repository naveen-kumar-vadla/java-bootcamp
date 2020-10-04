package com.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private int currentSlotNumber = 0;
    private final HashMap<ParkingLotEvent, List<ParkingLotListener>> allListeners = new HashMap<>();

    private final int capacity;
    private final Object[] parkingLot;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingLot = new Object[capacity];

        for (ParkingLotEvent event : ParkingLotEvent.values()) {
            this.allListeners.put(event, new ArrayList<>());
        }
    }

    public boolean park(Object car) {
        if (this.isFull()) {
            return false;
        }

        this.parkingLot[this.currentSlotNumber] = car;
        this.currentSlotNumber++;

        this.checkEventsAndPublish();

        return true;
    }

    private boolean isFull() {
        return this.currentSlotNumber >= this.capacity;
    }

    private boolean isAlmostFull() {
        return ((this.currentSlotNumber / (double) this.capacity) * 100) == 80;
    }

    private void checkEventsAndPublish() {
        if (this.isFull()) {
            publishEvent(ParkingLotEvent.FULL);
        }

        if (this.isAlmostFull()) {
            publishEvent(ParkingLotEvent.ALMOST_FULL);
        }
    }

    private void publishEvent(ParkingLotEvent parkingLotEvent) {
        final List<ParkingLotListener> eventListeners = this.allListeners.get(parkingLotEvent);
        final int slotsLeft = this.capacity - this.currentSlotNumber;
        final ParkingEventInfo parkingEventInfo = new ParkingEventInfo(this.capacity, slotsLeft, parkingLotEvent);

        for (final ParkingLotListener eventListener : eventListeners) {
            eventListener.publishEvent(parkingEventInfo);
        }
    }

    public void addEventListener(ParkingLotEvent parkingLotEvent, ParkingLotListener listener) {
        this.allListeners.get(parkingLotEvent).add(listener);
    }
}
