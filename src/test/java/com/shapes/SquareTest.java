package com.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {
  @Test
  void shouldGiveAreaOfTheSquare() {
    final Square square = new Square(2.0);
    assertEquals(4.0, square.area(), 0.0);
  }

  @Test
  void shouldGivePerimeterOfTheSquare() {
    final Square square = new Square(2.0);
    assertEquals(8.0, square.perimeter(), 0.0);
  }

}
