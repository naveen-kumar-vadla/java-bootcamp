package com.parking;

public class Slots {

    private final int capacity;
    private final Object[] slots;

    public Slots(int capacity) {
        this.capacity = capacity;
        this.slots = new Object[capacity];
    }

    public int addCar(Object car) {
        final int slotID = this.getFreeSlotID();

        if (slotID != -1) {
            this.slots[slotID] = car;
        }

        return slotID;
    }

    private int getFreeSlotID() {
        for (int i = 0; i < this.slots.length; i++) {
            if (this.slots[i] == null) {
                return i;
            }
        }

        return -1;
    }
}
