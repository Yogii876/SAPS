package Core;

public class Point {
		
	//private final int[] =  pOne = 24, pTwo = 20, pThree = 16, four = 0, five = 0;
	private int primaryPoints[] = {24, 20, 16, 0, 0};
	private int secondaryPoints[] = {10, 9, 8, 0, 0};
	private int tertiaryPoints[] = {3, 2, 1, 0, 0};
	//Secondary Requirements
	//private final int sOne = 10, sTwo = 9, sThree = 8;
	//Tertiary Requirements
	//private final int tOne = 3, tTwo = 2, tThree = 1;
	public Point() {
		
	}
	
	public int getPoints(String preRequisite, int grade) {
		int index = grade - 1;
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
}
