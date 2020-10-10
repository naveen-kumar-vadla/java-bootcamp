package com.parking;

import java.util.Objects;

public class ParkingEventInfo {
    private final int lotCapacity;
    private final int slotsLeft;
    private final ParkingLotEvent parkingEventType;

    public ParkingEventInfo(int lotCapacity, int slotsLeft, ParkingLotEvent parkingEventType) {
        this.lotCapacity = lotCapacity;
        this.slotsLeft = slotsLeft;
        this.parkingEventType = parkingEventType;
    }

    public int getLotCapacity() {
        return lotCapacity;
    }

    public int getSlotsLeft() {
        return slotsLeft;
    }

    public ParkingLotEvent getParkingEventType() {
        return parkingEventType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ParkingEventInfo)) {
            return false;
        }

        ParkingEventInfo that = (ParkingEventInfo) obj;
        return this.lotCapacity == that.lotCapacity &&
                this.slotsLeft == that.slotsLeft &&
                this.parkingEventType == that.parkingEventType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotCapacity, slotsLeft, parkingEventType);
    }
}
