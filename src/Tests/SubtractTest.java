package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Domain.Subtract;

public class SubtractTest {
  @Test
  public void shouldSubtractTwoNumbers() {
    Subtract subtract = new Subtract();
    assertEquals(2, subtract.Execute(5, 3), 0);
  }

  @Test
  public void shouldSumNegativeValue() {
    Subtract subtract = new Subtract();
    assertEquals(5, subtract.Execute(3, -2), 0);
  }
}
