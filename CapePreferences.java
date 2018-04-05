import java.util.Scanner;
public class CapePreferences {
	static String subj, pref1, pref2, pref3;
	public static void main (String[] args) {
		System.out.println("Enter subject for which you would like to set pre-requisites.");
		Scanner scanner = new Scanner(System.in);
		subj = scanner.nextLine();
		System.out.println("Enter primary pre-requisite for subject.");
		pref1 = scanner.nextLine();
		System.out.println("Enter secondary pre-requisite for subject.");
		pref2 = scanner.nextLine();
		System.out.println("Enter ternary pre-requisite for subject.");
		pref3 = scanner.nextLine();
	}
	
	public String getPref1(String subj) {
		return pref1;
	}
	
	public String getPref2(String subj) {
		return pref2;
	}
	
	public String getPref3(String subj) {
		return pref3;
	}
}
