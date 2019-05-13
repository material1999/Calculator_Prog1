package hu.uszeged.inf.core.builder;
import java.util.*;



/**
* <h1>Bivariate</h1>
* This class extends the Operation class for a bivariate (two parameter used) operation.
*/

public abstract class Bivariate extends Operation {
	
	public Bivariate(String id,String showingID, int priority) {
		/**
         * Constructor of the Bivariate class, pass the parameters to the Operation class.
         * @param String ID of the Operation.
         * @param String ShowingID of the Operation.
         * @param int Level of the operation's priority.
         */
		super(id,showingID, priority);
	}
	
	public final double doOperation(ArrayList<Double> arguments) {
		/**
         * This method prepare the argument(s) for the operation executing.
         * @param ArrayList<Double> Reference of the argument stack, stored in CoreBuilder.
         * 
         * @return double Return the result of the operation.
         */
		double param = Double.parseDouble(arguments.get(arguments.size()-1).toString());
		double param_2 = Double.parseDouble(arguments.get(arguments.size()-2).toString());
		arguments.remove(arguments.size()-1); 
		arguments.remove(arguments.size()-1);
		return operation(param,param_2);
	}
			
	protected abstract double operation(double param_1,double param_2); // This class will be specified/overrided in the child Classes only
	/**
     * This method will be specified/override in the child Classes only.
     * 
     * @param double The passed parameter from doOperation.
     * @param double The passed parameter from doOperation.
     * 
     * @return double Return the result of the operation.
     */
}
