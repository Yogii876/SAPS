package CSV;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		try {
			new Reader(new File("c:/users/yohan/Downloads/students2.csv"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
