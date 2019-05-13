package hu.uszeged.inf.core.builder;
import java.io.*;
import java.util.*;



/**
* <h1>ClassFinder</h1>
* This class will scan and return the list of files from the specified directory.
*/

public class ClassFinder {
	
	public static ArrayList<String> findClasses(String pathname) {
		/**
         * This method will scan the given directory and return the list of the containing files.
         * @param String The path of the scan directory.
         * @return ArrayList<String> The list of the founded files.
         */
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