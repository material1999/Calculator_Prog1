package hu.uszeged.inf.core.builder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import hu.uszeged.inf.core.processer.*;
import hu.uszeged.inf.core.builder.operations.*;
import hu.uszeged.inf.ui.*;

public final class CoreBuilder {
	private MainFrame UI;
	private HashMap<String,Operation> operations = new HashMap<String,Operation>();
	private HashMap<String, Boolean> runtimeLoaded = new HashMap<String, Boolean>();

	public ArrayList<Double> argumentStack = new ArrayList<Double>();
	
	public CoreBuilder() { 
		Addition addition = new Addition();
		operations.put(addition.id,addition);
		Division division = new Division();
		operations.put(division.id,division);
		Multiplication multiplication = new Multiplication();
		operations.put(multiplication.id,multiplication);
		Subtraction subtraction = new Subtraction();
		operations.put(subtraction.id,subtraction);		
	} 
	
	public double process(String raw_data){
		//Function<String, ArrayList> transform = Transform::toReversePolishNotation;
		for(String element : Transform.toReversePolishNotation(raw_data,this)) {
			
			try{
				argumentStack.add(Double.parseDouble(element));
			}
			catch(Exception e){
				argumentStack.add(executeOperation(element));
			}			
		}
		double result = argumentStack.get(0);
		argumentStack.clear();
		return result;
	}
	
	
	private double executeOperation(String id) {	
		
		 if (operations.containsKey(id)) return operations.get(id).doOperation(argumentStack);
		
		return 0;
	}

	public int getPriority(String id){
		if (operations.containsKey(id)) return operations.get(id).getPriority();
		
		return 0;
	}
	
	public void setTargetUI(MainFrame ui) {
		this.UI = ui;
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
						Operation runtime_operation = (Operation)operationInstance;
						runtime_operation.id = item.replace(".class","");
						operations.put(runtime_operation.id,runtime_operation);
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
