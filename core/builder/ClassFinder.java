import java.io.*;
import java.util.*;

public class ClassFinder {

	public ArrayList<String> findClasses() {
		File file = new File("./operations");
		ArrayList<String> classList = new ArrayList<String>();
		for (String classes : file.list(new ClassFilter())) {
			classList.add(classes.split("\\.")[0]);
		}
		return classList;
	}
}