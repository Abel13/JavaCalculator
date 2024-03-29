package main.java.com.abeldutra.javacalculator.API.Domain;

public abstract class Operation {
	public abstract double Execute(double a, double b);

	public abstract String GetName();

	public abstract String GetSymbol();
}
