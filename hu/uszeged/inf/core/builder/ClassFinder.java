package hu.uszeged.inf.core.builder;
import java.io.*;
import java.util.*;

public class ClassFinder {

	public ArrayList<String> findClasses(String pathname) {
		File file = new File(pathname);
		ArrayList<String> classList = new ArrayList<String>();
		for (String classes : file.list(new ClassFilter())) {
			classList.add(classes.split("\\.")[0]);
		}
		return classList;
	}
}