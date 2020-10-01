package com.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinProbability2Test {
  @Test
  void shouldGiveChanceOfGettingTail() {
    assertEquals(0.5, CoinProbability2.chanceOfGettingTail(), 0.0);
  }
}
