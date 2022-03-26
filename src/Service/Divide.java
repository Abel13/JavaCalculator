package Service;

public class Divide extends Operation {
  public double Execute(double a, double b) {
    if(b == 0) {
      throw new ArithmeticException("Não é possível dividir por zero");
    }
    return a / b;
  }
}
