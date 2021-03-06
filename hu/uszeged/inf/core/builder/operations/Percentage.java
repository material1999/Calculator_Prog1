package hu.uszeged.inf.core.builder.operations;
import hu.uszeged.inf.core.builder.*;

public class Percentage extends Bivariate {

	public Percentage() {
		super("%","%", 2);
	}

	protected double operation(double param_1, double param_2) {
		return param_2 % param_1;
	}
}