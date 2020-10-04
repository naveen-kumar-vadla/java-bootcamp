package com.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LengthTest {
  @Test
  void shouldCompareTwoEqualLengths() {
    Length length1 = new Length(1, LengthUnit.FEET);
    Length length2 = new Length(12, LengthUnit.INCH);

    assertEquals(length1, length2);
  }

  @Test
  void shouldNotCompareTwoUnequalLengths() {
    Length length1 = new Length(1, LengthUnit.FEET);
    Length length2 = new Length(11, LengthUnit.INCH);

    assertNotEquals(length1, length2);
  }

  @Test
  void shouldAddAnyTwoLengths() {
    Length length1 = new Length(2, LengthUnit.INCH);
    Length length2 = new Length(5, LengthUnit.CM);
    final Length expected = new Length(4, LengthUnit.INCH);

    assertEquals(expected, length1.add(length2));
  }
}
