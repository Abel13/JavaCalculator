package main.java.com.abeldutra.javacalculator.Domain;

public class Sum extends Operation {
  @Override
  public double Execute(double a, double b) {
    return a + b;
  }

  @Override
  public String GetName() {
    return "Soma";
  }

  @Override
  public String GetSymbol() {
    return "+";
  }
}
