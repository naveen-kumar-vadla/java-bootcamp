package com.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinFaceTest {

  @Test
  void shouldGiveChanceOfGettingTail() {
    assertEquals(0.5, CoinFace.TAIL.gettingChance());
  }

  @Test
  void shouldGiveChanceOfNotGettingTail() {
    assertEquals(0.5, CoinFace.TAIL.notGettingChance());
  }
}