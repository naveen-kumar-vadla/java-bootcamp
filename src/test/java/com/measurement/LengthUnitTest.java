package com.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthUnitTest {

  @Test
  void shouldConvertToInch() {
    assertEquals(2.0, LengthUnit.CM.toStandard(5.0));
    assertEquals(24.0, LengthUnit.FEET.toStandard(2.0));
    assertEquals(1.0, LengthUnit.MM.toStandard(25));
  }
}