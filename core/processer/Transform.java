import java.util.*;

public class Transform {

	public static ArrayList<String> toReversePolishNotation(String equation) {
		
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
				
				if (build.toString().equals("[(]")) {
					operationStack.add(build.toString());
					lastPriority = 0;
				}

				else if (build.toString().equals(")")) {
					int size = operationStack.size() - 1;
					while (!operationStack.get(size).equals("(")) {
						result.add(operationStack.get(size));
						operationStack.remove(size);
						--size;
					}
					operationStack.remove(size);
					//lastPriority = top operations priority
					System.out.println(result);
				}

				//else if the priority is bigger than the top of the stack
				//empty operationStack until the top is lower then actual priority
				else {
					if (false) {
						
					}
					operationStack.add(build.toString());
				}
				build.setLength(0);
				++i;
			}
			if (equation.charAt(i) == '=') {
				for (String j : operationStack) {
					result.add(j);
				}
			}
		}
		result.add("=");
		return result;
	}
}