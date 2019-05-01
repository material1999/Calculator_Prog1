package core.builder;
import java.util.ArrayList;
import core.*;


public final class CoreBuilder {
	
	private ArrayList<Operation> operations = new ArrayList<Operation>();
	private Map<String, boolean> runtimeLoaded = new Map<String, boolean>();

	public ArrayList<Double> argumentStack = new ArrayList<Double>();
	
	
	
	public CoreBuilder() { 	} 
	
	public double process(String raw_data){
		for(String element : Transform::toReversePolishNotation(raw_data,this)) {
			if(!argumentStack.add(Double.parseDouble(element))){
				argumentStack.add(executeOperation(element));
			}
		}
		return argumentStack[0];				
	}
	
	
	private double executeOperation(String id) {		
		for(Operation operation : operations) if(operation.getID() == id) return operation.doOperation(argumentStack);
		return 0;
	}

	public int getPriority(String id){
		for(Operation operation : operations) if(operation.getID() == id) return operation.getPriority();
	}
	
	public void loadOperation(Object operation) {
		// Need to call this function in the loaded operation class over the reflection to store it in the this.operations, find a free id and create a button
		ClassFinder classFinder = new ClassFinder();
        ArrayList<String> list = classFinder.findClasses();
        ClassLoader classLoader = this.getClass().getClassLoader();
        for (String item : list) {
        	if (!runtimeLoaded[item]) {
        		Class newOperation = classLoader.loadClass(item);
        		if (newOperation instanceof Linear || newOperation instanceof Bivariate || newOperation instanceof Trivariate) {
        				Constructor constructor = newOperation.getConstructor();
        				Operation operationInstance = constructor.newInstance();
        				operations.add(operationInstance);
        				runtimeLoaded[item] = true;
        		}
        	}
        }

	}
}
