package com.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
  @Test
  void shouldGiveAreaOfTheRectangle() {
    final Rectangle rectangle = new Rectangle(3.0, 2.0);
    assertEquals(6.0, rectangle.area());
  }

  @Test
  void shouldGivePerimeterOfTheRectangle() {
    final Rectangle rectangle = new Rectangle(2.0, 1.0);
    assertEquals(6.0, rectangle.perimeter());
  }

}
