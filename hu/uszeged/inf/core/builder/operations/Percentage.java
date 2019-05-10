package hu.uszeged.inf.core.builder.operations;
import hu.uszeged.inf.core.builder.*;

public class Percentage extends Linear {

	public Percentage() {
		super("%", 3);
	}

	protected double operation(double param_1) {
		return param_1 / 100;
	}
}