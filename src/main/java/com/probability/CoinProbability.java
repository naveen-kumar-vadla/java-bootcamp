package com.probability;

public class CoinProbability {
  public static final int TOTAL_PROBABILITY = 1;
  private final int noOfCoins;

  public CoinProbability(final int noOfCoins) {
    this.noOfCoins = noOfCoins;
  }

  public float gettingAllTails() {
    final int totalNoOfOutcomes = (int) Math.pow(2, this.noOfCoins);
    final int noOfPossibleOutcomes = 1;
    return (float) noOfPossibleOutcomes / totalNoOfOutcomes;
  }

  public float notGettingAllTails() {
    return TOTAL_PROBABILITY - this.gettingAllTails();
  }
}
