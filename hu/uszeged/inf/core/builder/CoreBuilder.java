package hu.uszeged.inf.core.builder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import hu.uszeged.inf.core.processer.*;
import hu.uszeged.inf.core.builder.*;

public final class CoreBuilder {
	
	private ArrayList<Operation> operations = new ArrayList<Operation>();
	private HashMap<String, Boolean> runtimeLoaded = new HashMap<String, Boolean>();

	public ArrayList<Double> argumentStack = new ArrayList<Double>();
	
	public CoreBuilder() { 	} 
	
	public double process(String raw_data){
		//Function<String, ArrayList> transform = Transform::toReversePolishNotation;
		for(String element : Transform.toReversePolishNotation(raw_data,this)) {
			if(!argumentStack.add(Double.parseDouble(element))) {
				argumentStack.add(executeOperation(element));
			}
		}
		return argumentStack.get(0);				
	}
	
	
	private double executeOperation(String id) {		
		for(Operation operation : operations) if(operation.getID() == id) return operation.doOperation(argumentStack);
		return 0;
	}

	public int getPriority(String id){
		for(Operation operation : operations) if(operation.getID() == id) return operation.getPriority();
		return 0;
	}
	
	public void loadOperation(Object operation) {
		// Need to call this function in the loaded operation class over the reflection to store it in the this.operations, find a free id and create a button
		ClassFinder classFinder = new ClassFinder();
        ArrayList<String> list = classFinder.findClasses();
       
        for (String item : list) {
        	if (!runtimeLoaded.get(item)) {
        		ClassLoader classLoader = this.getClass().getClassLoader();
        		Class newOperation;
				try {
					newOperation = classLoader.loadClass(item);
					Constructor constructor = newOperation.getConstructor();
					Object operationInstance = constructor.newInstance();
					if (operationInstance instanceof Linear || operationInstance instanceof Bivariate || operationInstance instanceof Trivariate) {
        				operations.add((Operation)operationInstance);
        				runtimeLoaded.put(item, true);
					}else {
						newOperation = null;
					}
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}       		
        		
        	}
        }

	}
}
