package com.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinProbabilityTest {
  @Test
  void shouldGiveChanceOfGettingTailsForOneCoin() {
    final CoinProbability singleCoinProbability = new CoinProbability(1);
    assertEquals(0.5, singleCoinProbability.gettingAllTails());
  }

  @Test
  void shouldGiveChangeOfNotGettingTailsForOnceCoin() {
    final CoinProbability singleCoinProbability = new CoinProbability(1);
    assertEquals(0.5, singleCoinProbability.notGettingAllTails());
  }

  @Test
  void shouldGiveChanceOfGettingTailsForTwoCoin() {
    final CoinProbability twoCoinsProbability = new CoinProbability(2);
    assertEquals(0.25, twoCoinsProbability.gettingAllTails());
  }
}
