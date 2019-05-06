import hu.uszeged.inf.core.processer.*;
import hu.uszeged.inf.core.builder.*;
import hu.uszeged.inf.ui.*;
import java.util.*;
import hu.uszeged.inf.core.builder.operations.*;

public class Tester {
	public static void main(String[] args) {
		
		CoreBuilder builder = new CoreBuilder();
		for(String val : Transform.toReversePolishNotation(args[0], builder)) {
			System.out.println(val);
		}

		//Division d = new Division();
		//Subtraction s = new Subtraction();
		
		/* Deprecated
        ClassFinder classFinder = new ClassFinder();
        ArrayList<String> list = classFinder.findClasses();
        System.out.println(list);
        */
	}
}