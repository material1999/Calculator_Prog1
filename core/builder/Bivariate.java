package core.builder;
public abstract class Bivariate extends Operation {
	
	public Bivariate(String id) {
		super(id);
	}
	
	public final double doOperation() {
		// operation(processzer.getParameter(),processzer.getParameter())
		return 0;
	}
			
	protected abstract double operation(double param_1,double param_2); // This class will be specified/overrided in the child Classes only
		
}
