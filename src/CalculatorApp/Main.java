package CalculatorApp;
import Domain.Calculator;

public class Main {
    static Calculator calculator;
    static String[] operators;

    private static int menu() {
        for (int i = 0; i < operators.length; i++) {
            System.out.println(i + " - " + operators[i]);
        }

        return (int)readValue("Escolha uma operação:");
    }
    
    private static void printResult(String result) {
        System.out.println("=====================");
        System.out.println(result);
        System.out.println("=====================");
    }

    private static double readValue(String message) {
        System.out.println(message);
        return Double.parseDouble(System.console().readLine());
    }

    public static void main(String[] args) {
        int option = -1;
        
        calculator = new Calculator();
        operators = calculator.GetOperationNames();

        while(readValue("Deseja efetuar algum calculo?\n0=NÃO\n1=SIM") != 0){
            option = menu();

            try {
                double a = readValue("Digite o primeiro número da operação[" + operators[option] + "]: ");
                double b = readValue("Digite o segundo número da operação[" + operators[option] + "]: ");

                printResult(calculator.Execute(option, a, b));
            } catch (Exception e) {
                printResult(e.getMessage());
            }
        }
    }
}
