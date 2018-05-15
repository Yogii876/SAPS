package Core;
import java.util.ArrayList; 
import java.util.Map;
import java.util.HashMap;

public class Student {
	private String fName, lName;
	private ArrayList<String> capeSubs;
	private ArrayList<CSEC> csecSubs;
	private ArrayList<CAPE> possibleSubjects = new ArrayList<CAPE>();
	private ArrayList<CAPE> acceptedFor = new ArrayList<CAPE>();
	private ArrayList<CAPE> conflicts = new ArrayList<CAPE>();
	private ArrayList<CAPE> alternates = new ArrayList<CAPE>();
	
	private Map<CAPE, Integer> pointMapping = new HashMap<CAPE, Integer>();
	
	public Student(String fName, String lName, ArrayList<CSEC> cssubs, ArrayList<String> casubs) {
		this.fName=fName;
		this.lName=lName;
		this.csecSubs = cssubs;
		this.capeSubs = casubs;
	}

	
	public String getFirstName() {
		return this.fName;
	}
	
	public String getLastName() {
		return this.lName;
	}
	
	public String getFullName() {
		return this.fName + " " + this.lName;
	}
	
	public ArrayList<String> getChoices() {
		return capeSubs;
	}
	
	public ArrayList<CSEC> getCSEC() {
		return csecSubs;
	}
	
	public int calcPoints(Point pnts, CAPE cape) {
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
			pointMapping.put(cape, totalPoints);
		}
		return totalPoints;
		
	}
	
	public Map<CAPE, Integer> getMapping() {
		return pointMapping;
	}
	
	public int getPoints(CAPE obj) {
		return pointMapping.get(obj);
	}
	
	public void addPossibleSub(CAPE subj) {
		possibleSubjects.add(subj);
	}
	
	
	public void addAcceptedSubject(CAPE sub) {
		this.acceptedFor.add(sub);
	}
	
	
	public String toString() {
		return fName + " " + lName;
	}


	public void addConflict(CAPE cape) {
		conflicts.add(cape);
		
	}


	public void addAlternate(CAPE cape) {
		alternates.add(cape);
		
	}
	
	private ArrayList<String> getString(ArrayList<CAPE> cSubs) {
		if (!cSubs.isEmpty()) {
			ArrayList<String> names = new ArrayList<String>();
			for (CAPE c : cSubs) {
				names.add(c.toString());
			}
			return names;
		}
		return null;
	}
	
	public ArrayList<String> getAlternates() {
		return getString(alternates);
	}
	
	public ArrayList<String> getConflicts() {
		return getString(conflicts);
	}
	
	public ArrayList<String> getAccepted() {
		return getString(acceptedFor);
	}
	
	public void removeSubject(CAPE c) {
		possibleSubjects.remove(c);
		conflicts.remove(c);
		alternates.remove(c);
		acceptedFor.remove(c);
	}
}
