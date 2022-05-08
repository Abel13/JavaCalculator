package Domain;

public class Power extends Operation {
  public double Execute(double a, double b) {
    return Math.pow(a, b);
  }

  public String GetName() {
    return "Potência";
  }

  @Override
  public String GetSymbol() {
    return "^";
  }
}
