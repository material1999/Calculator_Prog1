import java.util.*;

public class Tester {
	public static void main(String[] args) {
		
		Transform transform = new Transform();
		System.out.println(transform.toReversePolishNotation(args[0]));

        ClassFinder classFinder = new ClassFinder();
        ArrayList<String> list = classFinder.findClasses();
        System.out.println(list);
	}
}