package hu.uszeged.inf.core.builder.operations;
import hu.uszeged.inf.core.builder.*;

public class Subtraction extends Bivariate {

	public Subtraction() {
		super("-","-", 1);
	}

	protected double operation(double param_1, double param_2) {
		return param_2 - param_1;
	}
}