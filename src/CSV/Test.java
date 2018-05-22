package CSV;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CAPEReader cp = new CAPEReader(new File("c:/users/yohan/downloads/subjects.csv"));
			System.out.println(cp.getStudents());
			System.out.println(cp.getMap());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
