package core.builder;
public abstract class Bivariate extends Operation {
	
	public Bivariate(String id, int priority) {
		super(id, priority);
	}
	
	public final double doOperation(ArrayList<Double> arguments) {
		double param = Double.parseDouble(arguments[arguments.size()-1]);
		double param_2 = Double.parseDouble(arguments[arguments.size()-2]);
		arguments.remove(arguments.size()-1); 
		arguments.remove(arguments.size()-1);
		return operation(param,param_2);
	}
			
	protected abstract double operation(double param_1,double param_2); // This class will be specified/overrided in the child Classes only
		
}
