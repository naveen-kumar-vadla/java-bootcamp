package com.measurement;

public enum LengthUnit implements Unit {
  INCH(1.0), FEET(12.0), CM(0.4), MM(0.04);

  private final double conversionFactor;

  LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public static LengthUnit standardUnit() {
    return INCH;
  }

  @Override
  public double toStandard(double value) {
    return value * this.conversionFactor;
  }
}
