package CalculatorApp;

import java.util.Map;

import Service.Calculator;

public class Main {
    private static int menu() {
        System.out.println("Escolha uma operação!");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Sair");

        return Integer.parseInt(System.console().readLine());
    }

    private static String getOperator(int option) {
        var operators = Map.of(1, "+", 2, "-", 3, "×", 4, "÷");
        return operators.get(option);
    }
    
    private static void printResult(String result) {
        System.out.println("=====================");
        System.out.println(result);
        System.out.println("=====================");
    }

    public static void main(String[] args) {
        int option = 0;

        while(option != 5) {
            option = menu();
            
            if (option >= 1 && option <= 4) {
                try {
                    Calculator calculator = new Calculator(option);

                    System.out.println("Digite o primeiro número: ");
                    double a = Double.parseDouble(System.console().readLine());

                    System.out.println("Digite o segundo número: ");
                    double b = Double.parseDouble(System.console().readLine());

                    printResult(a + getOperator(option) + b + " = " + calculator.Execute(a, b));
                } catch (Exception e) {
                    printResult(e.getMessage());
                }
            }
        } ;
    }
}
