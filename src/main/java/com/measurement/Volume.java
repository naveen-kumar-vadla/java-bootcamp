package com.measurement;

import java.util.Objects;

public class Volume {
  private final double value;
  private final VolumeUnit unit;

  public Volume(final double value, final VolumeUnit unit) {
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
    final Volume volume = (Volume) o;

    return this.isEqualTo(volume);
  }

  private boolean isEqualTo(final Volume other) {
    final double thisInLiters = this.unit.toStandard(this.value);
    final double otherInLiters = other.unit.toStandard(other.value);

    return Math.abs(thisInLiters - otherInLiters) <= 0.1;
  }

  public Volume add(final Volume other) {
    final double thisInLiters = this.unit.toStandard(this.value);
    final double otherInLiters = other.unit.toStandard(other.value);
    final double totalInLiters = thisInLiters + otherInLiters;

    return new Volume(totalInLiters, VolumeUnit.standardUnit());
  }
}
