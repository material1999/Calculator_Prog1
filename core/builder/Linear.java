package core.builder;
public abstract class Linear extends Operation {

	public Linear(String id, int priority) {
		super(id, priority);
	}
	
	public final double doOperation(ArrayList<Double> arguments) {
		double param = Double.parseDouble(arguments[arguments.size()-1]);
		arguments.remove(arguments.size()-1); 
		return operation(param);
	}
	
	
	
	protected abstract double operation(double param); // This class will be specified/overrided in the child Classes only
			
	
}
