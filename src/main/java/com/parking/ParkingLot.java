package com.parking;

import java.util.*;

public class ParkingLot {
    private final HashMap<ParkingLotEvent, List<ParkingLotListener>> allListeners = new HashMap<>();
    private final int capacity;
    private final Object[] carSlots;
    private int currentSlotNumber = 0;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carSlots = new Object[capacity];

        for (ParkingLotEvent event : ParkingLotEvent.values()) {
            this.allListeners.put(event, new ArrayList<>());
        }
    }

    public int park(Object car) {
        if (this.isFull()) {
            return -1;
        }

        this.carSlots[this.currentSlotNumber] = car;
        final int slotID = this.currentSlotNumber++;

        this.publishOnParkEvents();

        return slotID;
    }

    private void publishOnParkEvents() {
        if (this.isFull()) {
            publishEvent(ParkingLotEvent.FULL);
        }

        if (this.isAlmostFull()) {
            publishEvent(ParkingLotEvent.ALMOST_FULL);
        }
    }

    private boolean isFull() {
        return this.getFilledSlotsCount() == this.capacity;
    }

    private boolean isAlmostFull() {
        return ((this.getFilledSlotsCount() / (double) this.capacity) * 100) == 80;
    }

    private void publishEvent(ParkingLotEvent parkingLotEvent) {
        final int slotsLeft = this.capacity - this.getFilledSlotsCount();
        final ParkingEventInfo parkingEventInfo = new ParkingEventInfo(this.capacity, slotsLeft, parkingLotEvent);

        final List<ParkingLotListener> eventListeners = this.allListeners.get(parkingLotEvent);

        for (final ParkingLotListener eventListener : eventListeners) {
            eventListener.handleParked(parkingEventInfo);
        }
    }

    public void addEventListener(ParkingLotEvent parkingLotEvent, ParkingLotListener listener) {
        this.allListeners.get(parkingLotEvent).add(listener);
    }

    public Object unPark(int slotID) {
        final Object car = this.carSlots[slotID];
        this.carSlots[slotID] = null;

        if (this.isAlmostEmpty()) {
            this.publishEvent(ParkingLotEvent.ALMOST_EMPTY);
        }

        return car;
    }

    private boolean isAlmostEmpty() {
        final int filledSlots = getFilledSlotsCount();
        return ((filledSlots / (double) this.capacity) * 100) <= 20.0;
    }

    private int getFilledSlotsCount() {
        return Arrays.stream(this.carSlots).filter(Objects::nonNull).toArray().length;
    }
}
