package com.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureUnitTest {
  @Test
  void shouldConvertToCelsius() {
    assertEquals(1, TemperatureUnit.FAHRENHEIT.toStandard(33.8), 0.1);
  }
}