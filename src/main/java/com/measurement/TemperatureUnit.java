package com.measurement;

public enum TemperatureUnit implements Unit {
  CELSIUS {
    @Override
    public double toStandard(final double value) {
      return value;
    }
  },
  FAHRENHEIT {
    @Override
    public double toStandard(final double value) {
      return (value - 32) * (5.0 / 9.0);
    }
  }
}
