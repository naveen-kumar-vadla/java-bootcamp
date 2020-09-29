package com.shapes;

public class Rectangle {
  private final double sideA;
  private final double sideB;

  public Rectangle(final double sideA, final double sideB) {
    this.sideA = sideA;
    this.sideB = sideB;
  }

  public void represent(Printer <Object> printer) {
    final double length = Math.max(this.sideA, this.sideB);
    final double width = Math.min(this.sideA, this.sideB);
    final String representation = String.format("length: %f\nwidth: %f\narea: %f\nperimeter: %f", length, width, this.area(), this.perimeter());
    printer.print(representation);
  }

  public double area() {
    return this.sideA * this.sideB;
  }

  public double perimeter() {
    return 2 * (this.sideA + this.sideB);
  }
}
