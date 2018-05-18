package Core;
import java.util.ArrayList; 
import java.util.Map;
import java.util.HashMap;

public class Student {
	private String fName, lName;
	private ArrayList<String> choices;
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
		this.choices = casubs;
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
		return choices;
	}
	
	public ArrayList<CSEC> getCSEC() {
		return csecSubs;
	}
	
	public int calcPoints(CAPE cape) {
		//TODO change
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
		
		if (pGrade > 0) {	
			totalPoints += Point.getPoints("primary", pGrade);
			if (tGrade != -1 ) totalPoints += Point.getPoints("tertiary", tGrade);
			else if (sGrade != -1 )	totalPoints += Point.getPoints("secondary", sGrade);
			
			//if (totalPoints == 0) System.out.println(this.toString() + "\t" + cape.getName() + ":\tPrimary Grade:\t" + pGrade + "\t" + totalPoints);
		}
		pointMapping.put(cape, totalPoints);
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
		String tFName = (fName.substring(0, 1).toUpperCase()).concat(fName.substring(1));
		String tLName = (lName.substring(0, 1).toUpperCase()).concat(lName.substring(1));
		return tFName + " " + tLName;
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
