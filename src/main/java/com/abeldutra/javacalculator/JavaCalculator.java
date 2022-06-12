/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package main.java.com.abeldutra.javacalculator;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author abelo
 */
public class JavaCalculator { 
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

    private static void getOperatorNames() {
        try {
            URL url = new URL("http://localhost:7070/operators/names");
            HttpURLConnection connection = 
                (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("charset", "utf-8");

            InputStream response = connection.getInputStream();

            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = response.read()) != -1) {
                sb.append((char) c);
            }
            String result = sb.toString();
            JSONArray json = new JSONArray(result);
            
            operators = json.toList().toArray(new String[0]);

            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Erro ao obter nomes de operadores" + e.getMessage());
        }
    }

    private static String getResult(int option, double value1, double value2) {
        try {
            URL url = new URL("http://localhost:7070/calculate/"+ option +"/" + value1 +"/" + value2);
            HttpURLConnection connection = 
                (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("charset", "utf-8");

            InputStream response = connection.getInputStream();

            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = response.read()) != -1) {
                sb.append((char) c);
            }
            String result = sb.toString();;

            connection.disconnect();
            return result;
        } catch (Exception e) {
            System.out.println("Erro ao obter nomes de operadores" + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        int option;
                
        getOperatorNames();

        while(readValue("Deseja efetuar algum calculo?\n0=NÃO\n1=SIM") != 0){
            option = menu();
            try {
                
                double a = readValue("Digite o primeiro número da operação[" + operators[option] + "]: ");
                double b = readValue("Digite o segundo número da operação[" + operators[option] + "]: ");

                printResult(getResult(option, a, b));
            } catch (Exception e) {
                printResult(e.getMessage());
            }
        }
    }   
}
