import java.util.ArrayList;


public final class Builder {
	
	private ArrayList<Operation> operations = new ArrayList<Operation>();
	
	public Builder() { // TODO :  Need to pass the reference of the processer and pass down to the Operation class for the parameter getting!
		
	}
	
	
	public double executeOperation(String id) {
		for(Operation operation : operations) if(operation.getID() == id) return operation.doOperation();
		return 0;
	}
	
	public void loadOperation(Object operation) {
		// Need to call this function in the loaded operation class over the reflection to store it in the this.operations, find a free id and create a button
	}
}
