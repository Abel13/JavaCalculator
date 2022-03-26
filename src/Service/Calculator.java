package Service;

import java.util.Map;

public class Calculator {
	private Map<Integer, Operation> operations;
	private Operation operation = null;

	public Calculator(int option) {
		operations = Map.of(1, new Sum(), 2, new Subtract(), 3, new Multiply(), 4, new Divide());
		operation = operations.get(option);
	}

	public double Execute(double a, double b) {
		return operation.Execute(a, b);
	}
}
