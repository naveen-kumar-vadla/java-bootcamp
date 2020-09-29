package com.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
  @Test
  void shouldGiveAreaOfTheRectangle() {
    final Rectangle rectangle = new Rectangle(3.0, 2.0);
    assertEquals(6.0, rectangle.area(), 0.0);
  }

  @Test
  void shouldGivePerimeterOfTheRectangle() {
    final Rectangle rectangle = new Rectangle(2.0, 1.0);
    assertEquals(6.0, rectangle.perimeter(), 0.0);
  }

  @Test
  void shouldRepresentTheRectangle() {
    final Rectangle rectangle = new Rectangle(2.0, 3.0);
    final String expected = "length: 3.000000\nwidth: 2.000000\narea: 6.000000\nperimeter: 10.000000";
    rectangle.represent((txt) -> assertEquals(expected, txt));
  }
}
