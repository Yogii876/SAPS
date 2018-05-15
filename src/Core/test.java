package Core;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> test = new ArrayList<String>();
		
		test.add("boy");
		test.add("girl");
		test.add("tom");
		test.add("dick");
		test.add("harry");
		test.add("genna");
		test.add("sue");
		
		System.out.println(test.contains("boy"));
		System.out.println(test.contains("tow"));
		System.out.println(test.contains("harry"));

	}

}
