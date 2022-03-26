package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Service.Divide;

public class DivideTest {
  @Test
  public void shouldDivideTwoNumbers() {
    Divide divide = new Divide();
    assertEquals(2, divide.Execute(10, 5), 0);
  }

  @Test
  public void shouldThrowExceptionWhenDivideByZero() {
    Divide divide = new Divide();
    Exception exception = assertThrows(ArithmeticException.class, () -> {
      divide.Execute(20, 0);
    });

    String expectedMessage = "Não é possível dividir por zero";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
