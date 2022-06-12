/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.abeldutra.javacalculator.Domain;

/**
 *
 * @author abelo
 */
import java.util.ArrayList;

public class Calculator {
	private ArrayList<Operation> operations;
	private Operation operation = null;

	public Calculator() {
		operations = new ArrayList<Operation>();

		operations.add(new Sum());
		operations.add(new Subtract());
		operations.add(new Multiply());
		operations.add(new Divide());
		operations.add(new Power());
	}

	public String Execute(Integer operationId, double a, double b) {
		operation = operations.get(operationId);
		return a + " " + operation.GetSymbol() + " " + b + " = " + operation.Execute(a, b);
	}

	public String[] GetOperationNames() {
		return operations.stream().map(Operation::GetName).toArray(String[]::new);
	}
}
