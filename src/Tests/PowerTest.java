package Tests;

import Service.Power;

import static org.junit.Assert.*;

import org.junit.Test;

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
