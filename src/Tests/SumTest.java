package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.abeldutra.javacalculator.Domain.Sum;

public class SumTest {
  @Test
  public void shouldSumTwoNumbers() {
    Sum sum = new Sum();
    assertEquals(6, sum.Execute(3, 3), 0);
  }

  @Test
  public void shouldSubtractNegativeValue() {
    Sum sum = new Sum();
    assertEquals(1, sum.Execute(3, -2), 0);
  }
}
