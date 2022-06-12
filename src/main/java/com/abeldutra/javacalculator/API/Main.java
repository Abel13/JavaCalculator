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
    
    app.get("/calculate/{option}/{value1}/{value2}", ctx -> {
      Calculator calculator = new Calculator();
      double value1 = Double.parseDouble(ctx.pathParam("value1"));
      double value2 = Double.parseDouble(ctx.pathParam("value2"));
      Integer option = Integer.parseInt(ctx.pathParam("option"));

      var result = calculator.Execute(option, value1, value2);


      ctx.json(result);
    });
  }
}
