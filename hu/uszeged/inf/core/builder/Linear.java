package hu.uszeged.inf.core.builder;
import java.util.*;

public abstract class Linear extends Operation {

	public Linear(String id, String showingID,int priority) {
		super(id, showingID,priority);
	}
	
	public final double doOperation(ArrayList<Double> arguments) {
		double param = Double.parseDouble(arguments.get(arguments.size()-1).toString());
		arguments.remove(arguments.size()-1); 
		return operation(param);
	}
	
	
	
	protected abstract double operation(double param); // This class will be specified/overrided in the child Classes only
			
	
}
