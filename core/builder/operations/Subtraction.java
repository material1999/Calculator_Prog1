package core.builder.operations;
import core.builder.*;

public class Subtraction extends Bivariate {

	public Subtraction() {
		super("-", 1);
	}

	protected double operation(double param_1, double param_2) {
		return param_1 - param_2;
	}
}