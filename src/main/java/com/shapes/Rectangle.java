package com.shapes;

import java.util.function.Consumer;

public class Rectangle {
  private final double sideA;
  private final double sideB;

  public Rectangle(final double sideA, final double sideB) {
    this.sideA = sideA;
    this.sideB = sideB;
  }

  public void represent(Consumer <RectangleView> consumer) {
    final double length = Math.max(this.sideA, this.sideB);
    final double width = Math.min(this.sideA, this.sideB);
    final RectangleView view = new RectangleView(length,width,this.area(),this.perimeter());
    consumer.accept(view);
  }

  public double area() {
    return this.sideA * this.sideB;
  }

  public double perimeter() {
    return 2 * (this.sideA + this.sideB);
  }
}
