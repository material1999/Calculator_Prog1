package hu.uszeged.inf.core.builder;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import hu.uszeged.inf.core.processer.*;
import hu.uszeged.inf.core.builder.operations.*;
import hu.uszeged.inf.ui.*;

public final class CoreBuilder {
	
	private MainFrame UI;
	private HashMap<String,Operation> operations = new HashMap<String,Operation>();
	private HashMap<String, Boolean> runtimeLoaded = new HashMap<String, Boolean>();
	//private static CoreBuilder instance = null;
	public ArrayList<Double> argumentStack = new ArrayList<Double>();
	
	
	 /*public static  CoreBuilder getInstance(MainFrame ui) { // Singleton
	    	if(instance == null) {
	    		instance = new CoreBuilder(ui);
	    	}
	    	return instance;
	    }
	    
	    public void finalize() {
	        instance = null;
	      }*/

	
	public CoreBuilder(MainFrame ui) {
		this.UI = ui;
		Addition addition = new Addition();
		operations.put(addition.id,addition);
		Division division = new Division();
		operations.put(division.id,division);
		Multiplication multiplication = new Multiplication();
		operations.put(multiplication.id,multiplication);
		Subtraction subtraction = new Subtraction();
		operations.put(subtraction.id,subtraction);
		Percentage percentage = new Percentage();
		operations.put(percentage.id,percentage);	
	}

	public CoreBuilder() {

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
	
	
	
	
   
	
	public  void loadOperation() {
		
		ClassFinder classFinder = new ClassFinder();
		String path =  new File("hu/uszeged/inf/core/builder/plugin").getAbsolutePath();
        ArrayList<String> list = classFinder.findClasses(path);
        for (String item : list) {
        	System.out.println(item);
        	try {
		        Class c = Class.forName("hu.uszeged.inf.core.builder.plugin."+item);
		        Object newInstance = c.newInstance();
		    	
		        if (newInstance instanceof Linear || newInstance instanceof Bivariate || newInstance instanceof Trivariate) {
		        	if(!runtimeLoaded.containsKey(item)) {
			        	Operation operation = (Operation) newInstance;
			        	operations.put(item, operation);
			        	UI.makeNewButton("["+item+"]", operation.getShowingID());
			        }
		        	
		        }
		      
		      
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
        }
		
		 
		 /*
		// Need to call this function in the loaded operation class over the reflection to store it in the this.operations, find a free id and create a button
		
       
      
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
						if(!runtimeLoaded.containsKey(item)) {
							operations.put(runtime_operation.id,runtime_operation);
							runtimeLoaded.put(item, true);
							 UI.makeNewButton("["+item+"]", "asd");
						}
					}else {
						newOperation = null;
					}
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}       		
        		
        	}
        }*/

	}
}
