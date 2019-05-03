package hu.uszeged.inf.core.builder;
import java.util.*;

public abstract class Operation {
	protected String id;
	protected int priority;
	public abstract double doOperation(ArrayList<Double> arguments);	
	public final String getID() {return this.id;}
	public final int getPriority() {return this.priority;}
	public Operation(String id, int priority) {this.id = id; this.priority = priority;}
}
