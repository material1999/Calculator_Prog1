package operationClasses.defaultOperations;

public class Subtraction {

	public static final int priority = 1;
	public static final int operand = 2;
	public static final String id = "[-]";

	public static int getPriority() {
		return this.priority;
	}

	public static int getOperand() {
		return this.operand;
	}

	public static String getId() {
		return this.id;
	}

}