package com.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TemperatureTest {
  @Test
  void shouldCompareTwoEqualTemperatures() {
    final Temperature temperatureInCelsius = new Temperature(1, TemperatureUnit.CELSIUS);
    final Temperature temperatureInFahrenheit = new Temperature(33.8, TemperatureUnit.FAHRENHEIT);

    assertEquals(temperatureInCelsius, temperatureInFahrenheit);
  }

  @Test
  void shouldCompareTwoUnequalTemperatures() {
    final Temperature temperatureInCelsius = new Temperature(1, TemperatureUnit.CELSIUS);
    final Temperature temperatureInFahrenheit = new Temperature(33.6, TemperatureUnit.FAHRENHEIT);

    assertNotEquals(temperatureInCelsius, temperatureInFahrenheit);
  }

}