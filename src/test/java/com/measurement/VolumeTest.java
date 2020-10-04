package com.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VolumeTest {
  @Test
  void shouldCompareTwoEqualVolumes() {
    final Volume volumeInGallon = new Volume(1, VolumeUnit.GALLON);
    final Volume volumeInLiters = new Volume(3.78, VolumeUnit.LITER);

    assertEquals(volumeInGallon, volumeInLiters);
  }

  @Test
  void shouldCompareTwoUnequalVolumes() {
    final Volume volumeInGallon = new Volume(1, VolumeUnit.GALLON);
    final Volume volumeInLiters = new Volume(3, VolumeUnit.LITER);

    assertNotEquals(volumeInGallon, volumeInLiters);
  }

  @Test
  void shouldAddTwoVolumes() {
    final Volume volumeInGallon = new Volume(1.0, VolumeUnit.GALLON);
    final Volume volumeInLiter = new Volume(1.0, VolumeUnit.LITER);
    final Volume expected = new Volume(4.78, VolumeUnit.LITER);

    assertEquals(expected, volumeInGallon.add(volumeInLiter));
  }
}
