/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package main.java.com.abeldutra.javacalculator;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;

/**
 *
 * @author abelo
 */
public class JavaCalculator { 
    static String[] operators;

    private static String request(String path) {
        try {
            URL url = new URL("http://localhost:7070" + path);
            HttpURLConnection connection = 
            (HttpURLConnection) url.openConnection();
        
            connection.setRequestMethod("GET");
            connection.setRequestProperty("content-type", "application/json;  charset=utf-8");

            InputStream response = connection.getInputStream();

            Scanner scanner = new Scanner(response, "UTF-8");
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                connection.disconnect();
                return scanner.next();
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

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
            String response = request("/operators/names");

            if(response != null) {
                JSONArray jsonArray = new JSONArray(response);
                operators = jsonArray.toList().toArray(new String[0]);
            }

        } catch (Exception e) {
            System.out.println("Erro ao obter nomes de operadores" + e.getMessage());
        }
    }

    private static String getResult(int option, double value1, double value2) {
        try {
            String result = "";
            String response = request("/calculate/"+ option +"/" + value1 +"/" + value2);

            if(response != null) {
                result = response;
            }
            
            return result;
        } catch (Exception e) {
            System.out.println("Erro ao efetuar calculo" + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        try {
            int option;
            
            getOperatorNames();
            
            while(readValue("Deseja efetuar algum calculo?\n0=NÃO\n1=SIM") != 0){
                option = menu();
                
                double a = readValue("Digite o primeiro número da operação[" + operators[option] + "]: ");
                double b = readValue("Digite o segundo número da operação[" + operators[option] + "]: ");

                printResult(getResult(option, a, b));
            }
        } catch (Exception e) {
            printResult(e.getMessage());
        }
    }   
}
