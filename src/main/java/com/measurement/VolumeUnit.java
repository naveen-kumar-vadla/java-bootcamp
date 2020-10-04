package com.measurement;

public enum VolumeUnit implements Unit {
  LITER(1.0), GALLON(3.78);

  private final double conversionFactor;

  VolumeUnit(final double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public static VolumeUnit standardUnit() {
    return LITER;
  }

  @Override
  public double toStandard(final double value) {
    return value * this.conversionFactor;
  }
}
