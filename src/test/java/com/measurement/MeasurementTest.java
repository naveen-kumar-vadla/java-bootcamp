package com.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MeasurementTest {
  @Test
  void shouldCompareTwoEqualMeasurements() {
    final Measurement <TemperatureUnit> temperatureInC = new Measurement <>(1, TemperatureUnit.CELSIUS);
    final Measurement <TemperatureUnit> temperatureInF = new Measurement <>(33.8, TemperatureUnit.FAHRENHEIT);

    assertEquals(temperatureInC, temperatureInF);
  }

  @Test
  void shouldCompareTwoUnequalMeasurements() {
    final Measurement <LengthUnit> lengthInFeet = new Measurement <>(1, LengthUnit.FEET);
    final Measurement <LengthUnit> lengthInInch = new Measurement <>(11, LengthUnit.INCH);

    assertNotEquals(lengthInFeet, lengthInInch);
  }
}
