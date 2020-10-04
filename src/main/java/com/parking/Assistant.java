package com.parking;

import java.util.Objects;

public class Assistant {
    private final ParkingLots parkingLots;

    public Assistant(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingStatus park(Object car) {
        return this.parkingLots.park(car);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Assistant)) return false;

        Assistant other = (Assistant) obj;
        return this.parkingLots.equals(other.parkingLots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.parkingLots);
    }
}
