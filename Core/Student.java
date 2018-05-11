package Core;
import java.util.ArrayList; 

public class Student {
	private int sid;
	private String fName, lName;
	private ArrayList<String> capeSubs;
	private ArrayList<CSEC> csecSubs;
	private ArrayList<CapePoints> pointsMapping;
	
	public Student(int id, String fName, String lName, ArrayList<CSEC> cssubs, ArrayList<String> casubs) {
		this.sid = id;
		this.fName=fName;
		this.lName=lName;
		this.csecSubs = cssubs;
		this.capeSubs = casubs;
	}
	
	public int getSid() {
		return this.sid;
	}
	
	public String getFirstName() {
		return this.fName;
	}
	
	public String getLastName() {
		return this.lName;
	}
	
	public ArrayList<String> getCape() {
		return capeSubs;
	}
	
	public ArrayList<CSEC> getCSEC() {
		return csecSubs;
	}
	
	public void calcPoints(Point pnts, CAPE cape) {
		String primary = cape.getPrimary();
		String secondary = cape.getSecondary();
		String tertiary = cape.getTertiary();
		int pGrade = -1;
		int sGrade = -1;
		int tGrade = -1;
		int totalPoints = 0;
		
		if (tertiary != null) {
			for (int i = 0; i < csecSubs.size() - 1; i++) {
				if (csecSubs.get(i).getName().equals(primary)) {
					pGrade = csecSubs.get(i).getGrade();
				} 
				if (csecSubs.get(i).getName().equals(secondary)) {
					sGrade = csecSubs.get(i).getGrade();
				} 
				if (csecSubs.get(i).getName().equals(tertiary)) {
					tGrade = csecSubs.get(i).getGrade();
				} 
			}
		}
		else if (secondary != null) {
			for (int i = 0; i < csecSubs.size() - 1; i++) {
				if (csecSubs.get(i).getName().equals(primary)) {
					pGrade = csecSubs.get(i).getGrade();
				} 
				if (csecSubs.get(i).getName().equals(secondary)) {
					sGrade = csecSubs.get(i).getGrade();
				}
			}
		}
		else {
			for (int i = 0; i < csecSubs.size() - 1; i++) {
				if (csecSubs.get(i).getName().equals(primary)) {
					pGrade = csecSubs.get(i).getGrade();
				} 
			}
		}
		
		if (tGrade != -1 ) {
			totalPoints = pnts.getPoints("primary", pGrade) + pnts.getPoints("secondary", sGrade) + pnts.getPoints("tertiary", tGrade);
			pointsMapping.add(new CapePoints(cape.getName(), totalPoints));
		}
		
		else if (sGrade != -1) {
			totalPoints = pnts.getPoints("primary", pGrade) + pnts.getPoints("secondary", sGrade);
			pointsMapping.add(new CapePoints(cape.getName(), totalPoints));
		}
		
		else {
			totalPoints = pnts.getPoints("primary", pGrade);
			pointsMapping.add(new CapePoints(cape.getName(), totalPoints));
		}
		
	}
	
	public CapePoints getMapping(int index) {
		return pointsMapping.get(index);
	}

}
