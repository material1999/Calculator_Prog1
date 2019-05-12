package hu.uszeged.inf.core.builder.operations;
import hu.uszeged.inf.core.builder.*;

public class Addition extends Bivariate {
	public String id = "+";
	public String showingID = "+";
	public Addition() {
		super("+","+", 1);
	}

	protected double operation(double param_1, double param_2) {
		return param_1 + param_2;
	}
}