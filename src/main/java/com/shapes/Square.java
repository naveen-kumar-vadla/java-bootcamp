package com.shapes;

public class Square {
  private final double side;

  public Square(final double side) {
    this.side = side;
  }

  public double area() {
    return this.side * this.side;
  }

  public double perimeter() {
    return 4 * this.side;
  }
}
