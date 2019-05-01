package core.builder;
public abstract class Operation {
	protected String id;
	public abstract double doOperation();	
	public final String getID() {return this.id;}
	public Operation(String id) {this.id = id;}
}
