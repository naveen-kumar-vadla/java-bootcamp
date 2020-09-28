package com.shapes;

public class Rectangle {
  private final double length;
  private final double breadth;

  public Rectangle(final double length, final double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public double area() {
    return this.length * this.breadth;
  }

  public double perimeter() {
    return 2 * (this.length + this.breadth);
  }
}
