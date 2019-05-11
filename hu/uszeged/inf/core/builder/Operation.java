package hu.uszeged.inf.core.builder;
import java.util.*;

public abstract class Operation {
	protected String id;
	protected String showingID;
	protected int priority;
	public abstract double doOperation(ArrayList<Double> arguments);	
	public final String getID() {return this.id;}
	public final String getShowingID() {return this.showingID;}
	public final int getPriority() {return this.priority;}
	public Operation(String id, String showingID,int priority) {this.id = id; this.showingID = showingID;this.priority = priority;}
}
