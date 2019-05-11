package hu.uszeged.inf.core.builder;
import java.util.*;

public abstract class Trivariate extends Operation{
	public Trivariate(String id,String showingID, int priority) {
		super(id,showingID, priority);
	}
	
	public final double doOperation(ArrayList<Double> arguments) {
		double param = Double.parseDouble(arguments.get(arguments.size()-1).toString());
		double param_2 = Double.parseDouble(arguments.get(arguments.size()-2).toString());
		double param_3 = Double.parseDouble(arguments.get(arguments.size()-3).toString());
		arguments.remove(arguments.size()-1); 
		arguments.remove(arguments.size()-1);
		arguments.remove(arguments.size()-1);
		return operation(param,param_2,param_3);
	}
	
		
	protected abstract double operation(double param_1,double param_2,double param_3); // This class will be specified/overrided in the child Classes only
	
}

