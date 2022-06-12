package main.java.com.abeldutra.javacalculator.Domain;

public class Multiply extends Operation {
  @Override
  public double Execute(double a, double b) {
    return a * b;
  }

  @Override
  public String GetName() {
    return "Multiplicação";
  }

  @Override
  public String GetSymbol() {
    return "×";
  }
}
