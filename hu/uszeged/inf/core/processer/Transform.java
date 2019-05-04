package hu.uszeged.inf.core.processer;
import java.util.*;
import hu.uszeged.inf.core.builder.*;
import hu.uszeged.inf.core.builder.operations.*;

public class Transform {

	public static ArrayList<String> toReversePolishNotation(String equation,CoreBuilder builder) {
		
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> operationStack = new ArrayList<String>();
		int lastPriority = 0;
		StringBuilder build = new StringBuilder("");
		int i = 0;
		while (equation.charAt(i) != '=') {
			if (equation.charAt(i) == '{') {
				++i;
				while (equation.charAt(i) != '}') {
					build.append(equation.charAt(i));
					++i;
				}
				result.add(build.toString());
				build.setLength(0);
				++i;
			}
			if (equation.charAt(i) == '[') {
				++i;
				while (equation.charAt(i) != ']') {
					build.append(equation.charAt(i));
					++i;
				}
				if (build.toString().equals("(")) {
					operationStack.add(build.toString());
					lastPriority = 0;
				}
				else if (build.toString().equals(")")) {
					while (!(operationStack.get(operationStack.size() - 1).equals("("))) {
						if (operationStack.size() > 0) {
							result.add(operationStack.get(operationStack.size() - 1));
							operationStack.remove(operationStack.size() - 1);
						}
					}
					operationStack.remove(operationStack.size() - 1);
					if (operationStack.size() > 0) {
						lastPriority = builder.getPriority(operationStack.get(operationStack.size() - 1));
					}
					else lastPriority = 0;
				}
				else {
					while (builder.getPriority(build.toString()) <= lastPriority) {
						if (operationStack.size() > 0) {
							result.add(operationStack.get(operationStack.size() - 1));
							operationStack.remove(operationStack.size() - 1);
							if (operationStack.size() > 0) {
								lastPriority = builder.getPriority(operationStack.get(operationStack.size() - 1));
							}
						}
						else lastPriority = 0;
					}
					operationStack.add(build.toString());
					lastPriority = builder.getPriority(operationStack.get(operationStack.size() - 1));
				}
				build.setLength(0);
				++i;
			}
			if (equation.charAt(i) == '=') {
				for (int j = operationStack.size() - 1; j >= 0; j--) {
					result.add(operationStack.get(j));
				}
			}
		}
		result.add("=");
		return result;
	}
}