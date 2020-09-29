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
    rectangle.represent((view) -> {
      assertEquals(3.0, view.length);
      assertEquals(2.0, view.width);
      assertEquals(6.0, view.area);
      assertEquals(10.0, view.perimeter);
    });
//    rectangle.represent(view -> {
//      System.out.println("length : " + view.length);
//      System.out.println("width : " + view.width);
//      System.out.println("area : " + view.area);
//      System.out.println("perimeter : " + view.perimeter);
//    });
  }
}
