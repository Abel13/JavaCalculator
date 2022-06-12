package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.abeldutra.javacalculator.API.Domain.Multiply;

public class MultiplyTest {
  @Test
  public void shouldMultiplyTwoNumbers() {
    Multiply multiply = new Multiply();
    assertEquals(15, multiply.Execute(5, 3), 0);
  }
}
