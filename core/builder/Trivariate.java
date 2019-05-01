
public abstract class Trivariate extends Operation{
	public Trivariate(String id, int priority) {
		super(id, priority);
	}
	
	public final double doOperation() {
		//return operation(processzer.getParameter(),processzer.getParameter(),processzer.getParameter())
		return 0;
	}
	
		
	protected abstract double operation(double param_1,double param_2,double param_3); // This class will be specified/overrided in the child Classes only
	
}

