public class Multiplication extends Bivariate {

	public Multiplication() {
		super("[*]", 2);
	}

	@Override
	protected double operation(double param_1,double param_2) {
		return param_1 * param_2;
}