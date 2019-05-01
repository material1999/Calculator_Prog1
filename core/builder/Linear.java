package core.builder;
public abstract class Linear extends Operation {

	public Linear(String id, int priority) {
		super(id, priority);
	}
	
	public final double doOperation() {
		// operation(processzer.getParameter())
		return 0;
	}
	
	
	
	protected abstract double operation(double param); // This class will be specified/overrided in the child Classes only
			
	
}
