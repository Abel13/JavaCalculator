package main.java.com.abeldutra.javacalculator.API;

import io.javalin.Javalin;
import main.java.com.abeldutra.javacalculator.Domain.Calculator;

public class Main {
  public static void main(String[] args) {
    Javalin app = Javalin.create().start(7070);
    
    app.get("/operators/names", ctx -> {
      Calculator calculator = new Calculator();

      var operators = calculator.GetOperationNames();

      ctx.json(operators);
    });
  }
}
