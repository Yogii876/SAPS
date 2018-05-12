package Core;
import java.util.ArrayList; 
import java.util.Map;
import java.util.HashMap;

public class Student {
	private int sid;
	private String fName, lName;
	private ArrayList<String> capeSubs;
	private ArrayList<CSEC> csecSubs;
	private ArrayList<String> possibleSubjects = new ArrayList<String>();
	private Map<CAPE, Integer> pointMapping = new HashMap<CAPE, Integer>();
	
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
		
		if (tGrade > 4 || tGrade == -1 || sGrade == -1 || sGrade > 4 || pGrade > 4) {		
			if (tGrade != -1 ) {
				totalPoints = pnts.getPoints("primary", pGrade) + pnts.getPoints("secondary", sGrade) + pnts.getPoints("tertiary", tGrade);
				pointMapping.put(cape, totalPoints);
			}
			
			else if (sGrade != -1 ) {
				totalPoints = pnts.getPoints("primary", pGrade) + pnts.getPoints("secondary", sGrade);
				pointMapping.put(cape, totalPoints);
			}
			
			else {
				totalPoints = pnts.getPoints("primary", pGrade);
				pointMapping.put(cape, totalPoints);
			}
		}
		else {
			pointMapping.put(cape, 0);
		}
		
	}
	
	public Map<CAPE, Integer> getMapping() {
		return pointMapping;
	}
	
	public int getPoints(CAPE obj) {
		return pointMapping.get(obj);
	}
	
	public void addPossibleSub(String name) {
		possibleSubjects.add(name);
	}
	
	public ArrayList<String> getPossibleSubjects() {
		return possibleSubjects;
	}

}
