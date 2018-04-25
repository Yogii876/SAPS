package Core;

public class CapePoints {
	public String cname;
	public int points;
	
	public CapePoints(String name, int points) {
		this.cname = name;
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}
	
	public String getName() {
		return cname;
	}
}
