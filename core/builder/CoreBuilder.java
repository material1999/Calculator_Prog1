package core.builder;
import java.util.ArrayList;
import core.*;


public final class CoreBuilder {
	
	private ArrayList<Operation> operations = new ArrayList<Operation>();
	
	
	
	public CoreBuilder() { 	} 
	
	public double process(String raw_data){
		for(String element : Transform::toReversePolishNotation(raw_data)) {
			
		}
				
	}
	
	
	private double executeOperation(String id) {
		for(Operation operation : operations) if(operation.getID() == id) return operation.doOperation();
		return 0;
	}
	
	public void loadOperation(Object operation) {
		// Need to call this function in the loaded operation class over the reflection to store it in the this.operations, find a free id and create a button
	}
}
