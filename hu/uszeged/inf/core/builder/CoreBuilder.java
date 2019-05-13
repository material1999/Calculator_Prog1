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
	private ArrayList<Double> argumentStack = new ArrayList<Double>();
	
	
	
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
	
	public String getShowingId(String id) {
		if (operations.containsKey(id)) return operations.get(id).getShowingID();
		return "";
	}
	
	public  void loadOperation() {

		String path =  new File("hu/uszeged/inf/core/builder/plugin").getAbsolutePath();
        ArrayList<String> list = ClassFinder.findClasses(path);

        for (String item : list) {
        	System.out.println(item);
        	try {
		        Class c = Class.forName("hu.uszeged.inf.core.builder.plugin."+item);
		        Object newInstance = c.newInstance();
		    	
		        if (newInstance instanceof Linear || newInstance instanceof Bivariate || newInstance instanceof Trivariate) {
		        	if(!(runtimeLoaded.containsKey(item))) {
		        		runtimeLoaded.put(item, true);
			        	Operation operation = (Operation) newInstance;
			        	operations.put(item, operation);
			        	UI.makeNewButton("["+item+"]", operation.getShowingID());
			        }	
		        }
		      
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
        }		 
		
	}
}
