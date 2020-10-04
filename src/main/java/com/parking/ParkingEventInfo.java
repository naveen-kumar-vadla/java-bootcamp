package com.parking;

import java.util.Objects;

public class ParkingEventInfo {
    private final int lotCapacity;
    private final int slotsLeft;
    private final ParkingLotEvent parkingLotEvent;

    public ParkingEventInfo(int lotCapacity, int slotsLeft, ParkingLotEvent parkingLotEvent) {
        this.lotCapacity = lotCapacity;
        this.slotsLeft = slotsLeft;
        this.parkingLotEvent = parkingLotEvent;
    }

    public int getLotCapacity() {
        return lotCapacity;
    }

    public int getSlotsLeft() {
        return slotsLeft;
    }

    public ParkingLotEvent getParkingLotEvent() {
        return parkingLotEvent;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof ParkingEventInfo)) {
            return false;
        }

        ParkingEventInfo that = (ParkingEventInfo) object;
        return this.lotCapacity == that.lotCapacity &&
                this.slotsLeft == that.slotsLeft &&
                this.parkingLotEvent == that.parkingLotEvent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotCapacity, slotsLeft, parkingLotEvent);
    }
}
