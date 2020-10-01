package com.probability;

public enum CoinFace {
  TAIL(0.5);

  public static final int TOTAL_PROBABILITY = 1;
  private final double chance;

  CoinFace(double chance) {
    this.chance = chance;
  }

  public double notGettingChance() {
    return TOTAL_PROBABILITY - this.gettingChance();
  }

  public double gettingChance() {
    return this.chance;
  }
}