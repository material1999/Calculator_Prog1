import java.io.*;

public class ClassFilter implements FilenameFilter {

	public boolean accept(File current, String name) {
		return name.endsWith(".class");
	}
}