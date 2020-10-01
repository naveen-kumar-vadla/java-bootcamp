package com.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbabilityTest {
  @Test
  void shouldGiveComplimentOfGivenProbability() {
    final Probability probability = new Probability(0.25f);
    assertEquals(new Probability(0.75f), probability.complement());
  }

  @Test
  void shouldGiveAndOfGivenTwoProbabilities() {
    final Probability probability1 = new Probability(0.25f);
    final Probability probability2 = new Probability(0.5f);
    assertEquals(new Probability(0.125f), probability1.and(probability2));
  }

  @Test
  void shouldGiveOrOfGivenTwoProbabilities() {
    final Probability probability1 = new Probability(0.5f);
    final Probability probability2 = new Probability(0.5f);
    assertEquals(new Probability(0.75f), probability1.or(probability2));
  }
}
