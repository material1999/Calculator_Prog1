package hu.uszeged.inf.core.builder.operations;
import hu.uszeged.inf.core.builder.*;

public class Multiplication extends Bivariate {

	public Multiplication() {
		super("*","*", 2);
	}

	protected double operation(double param_1, double param_2) {
		return param_1 * param_2;
	}
}