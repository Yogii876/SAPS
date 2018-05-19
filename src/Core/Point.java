package Core;

public class Point {
		
	private static int primaryPoints[] = {300, 200, 100, 0, 0};
	private static int secondaryPoints[] = {30, 20, 10, 0, 0};
	private static int tertiaryPoints[] = {3, 2, 1, 0, 0};
	
	public static int getPoints(String preRequisite, int grade) {
		int index = grade - 1;
		try {
			if (preRequisite.equals("primary")) {
				
				return primaryPoints[index];
			}
			else if (preRequisite.equals("secondary")) {
				return secondaryPoints[index];
			}
			else {
				return tertiaryPoints[index];
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
}
