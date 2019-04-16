import operationClasses.defaultOperations.*;

public class Tester {
	public static void main(String[] args) {
		Transform transform = new Transform();
		System.out.println(transform.toReversePolishNotation(args[0]));
	}
}