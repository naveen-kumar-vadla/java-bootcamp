package com.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingEventInfoTest {

    @Test
    void shouldGiveTrueWhenTwoEventInfoHasSameFieldValues() {
        final ParkingEventInfo parkingEventInfo1 = new ParkingEventInfo(2, 0, ParkingLotEvent.FULL);
        final ParkingEventInfo parkingEventInfo2= new ParkingEventInfo(2, 0, ParkingLotEvent.FULL);

        assertEquals(parkingEventInfo1, parkingEventInfo2);
    }
}