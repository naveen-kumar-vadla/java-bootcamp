package com.probability;

//public class CoinProbability {
//  public static double chanceOfGettingTail() {
//    return 0.5;
//  }
//}


public class CoinProbability2 {
  static final int totalPossibleOutcomes = 2;

  public static double chanceOfGettingTail() {
    final int noOfPossibleOutcomes = 1;
    return (double) noOfPossibleOutcomes / totalPossibleOutcomes;
  }
}
