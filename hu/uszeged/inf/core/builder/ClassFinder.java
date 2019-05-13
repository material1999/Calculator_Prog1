package hu.uszeged.inf.core.builder;
import java.io.*;
import java.util.*;

public class ClassFinder {

	public static ArrayList<String> findClasses(String pathname) {
		File folder = new File(pathname);
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> classList = new ArrayList<String>();
		for (File classes : listOfFiles) {
			 if (classes.isFile() && classes.getName().contains(".java")) {
				 classList.add(classes.getName().replace(".java", ""));
			 }
		}
		return classList;
	}
}