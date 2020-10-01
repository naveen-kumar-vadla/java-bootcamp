package com.probability;

import java.util.Objects;

public class Probability {
  public static final byte MAXIMUM_PROBABILITY = 1;
  private final float value;

  public Probability(float value) {
    this.value = value;
  }

  public Probability or(Probability other) {
    final Probability thisComplement = this.complement();
    final Probability otherComplement = other.complement();
    return thisComplement.and(otherComplement).complement();
  }

  public Probability complement() {
    return new Probability(MAXIMUM_PROBABILITY - this.value);
  }

  public Probability and(Probability other) {
    return new Probability(this.value * other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(!(obj instanceof Probability)) return false;

    Probability that = (Probability) obj;
    return Float.compare(this.value, that.value) == 0;
  }
}
