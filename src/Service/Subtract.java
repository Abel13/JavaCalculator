package Service;

public class Subtract extends Operation {
  public double Execute(double a, double b) {
    return a - b;
  }

  @Override
  public String GetName() {
    return "Subtração";
  }

  @Override
  public String GetSymbol() {
    return "-";
  }
}
