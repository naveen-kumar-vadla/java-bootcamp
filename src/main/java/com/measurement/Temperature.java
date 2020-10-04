package com.measurement;

import java.util.Objects;

public class Temperature {
  private final double value;
  private final TemperatureUnit unit;

  public Temperature(final double value, final TemperatureUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unit.toStandard(this.value));
  }

  @Override
  public boolean equals(final Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    final Temperature volume = (Temperature) o;

    return this.isEqualTo(volume);
  }

  private boolean isEqualTo(final Temperature other) {
    final double thisInCelsius = this.unit.toStandard(this.value);
    final double otherInCelsius = other.unit.toStandard(other.value);

    return Math.abs(thisInCelsius - otherInCelsius) <= 0.1;
  }
}
