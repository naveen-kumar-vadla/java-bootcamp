package com.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolumeUnitTest {

  @Test
  void shouldConvertToLiters() {
    assertEquals(7.56, VolumeUnit.GALLON.toStandard(2));
  }
}