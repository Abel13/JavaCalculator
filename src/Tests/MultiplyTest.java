package Tests;

import Service.Multiply;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyTest {
  @Test
  public void shouldMultiplyTwoNumbers() {
    Multiply multiply = new Multiply();
    assertEquals(15, multiply.Execute(5, 3), 0);
  }
}
