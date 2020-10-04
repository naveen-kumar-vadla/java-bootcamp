package com.measurement;

import java.util.Objects;

public class Measurement <U extends Unit> {
  private final double value;
  private final U unit;
  private Measurement <U> other;

  public Measurement(final double value, final U unit) {
    this.value = value;
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }

  @Override
  public boolean equals(final Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    final Measurement <U> that = (Measurement <U>) o;
    return this.isEqualTo(that);
  }

  private boolean isEqualTo(final Measurement <U> other) {
    final double unitValue1 = this.unit.toStandard(this.value);
    final double unitValue2 = other.unit.toStandard(other.value);
    return Math.abs(unitValue1 - unitValue2) <= 0.1;
  }
}
