package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.abeldutra.javacalculator.API.Domain.Power;

public class PowerTest {
  @Test
  public void shouldPowerNumberOneByNumberTwo() {
    Power power = new Power();
    assertEquals(8, power.Execute(2, 3), 0);
  }

  @Test
  public void shouldPowerNumberOneByNegativeNumber() {
    Power power = new Power();
    assertEquals(0.25, power.Execute(2, -2), 0);
  }
}
