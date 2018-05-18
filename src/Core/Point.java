package Core;

public class Point {
		
	private static int primaryPoints[] = {24, 20, 16, 0, 0};
	private static int secondaryPoints[] = {10, 9, 8, 0, 0};
	private static int tertiaryPoints[] = {3, 2, 1, 0, 0};

	public Point() {
		
	}
	
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
