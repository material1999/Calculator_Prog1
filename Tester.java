import hu.uszeged.inf.core.processer.*;
import hu.uszeged.inf.core.builder.*;
import hu.uszeged.inf.ui.*;

import java.io.File;
import java.util.*;
import hu.uszeged.inf.core.builder.operations.*;

public class Tester {
	public static void main(String[] args) {

		File actual = new File(".");
		for( File f : actual.listFiles()){
			System.out.println( f.getName() );
		}
	}
}