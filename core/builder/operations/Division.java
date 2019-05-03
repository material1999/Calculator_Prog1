package core.builder.operations;
import core.builder.*;

public class Division extends Bivariate {

	public Division() {
		super("/", 2);
	}

	protected double operation(double param_1, double param_2) {
		return param_1 / param_2;
	}
}