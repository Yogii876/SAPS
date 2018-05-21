 package Core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Student {
	private String fName, lName;
	private ArrayList<String> choices;
	private ArrayList<CSEC> csecSubs;
	private ArrayList<CAPE> possibleSubjects = new ArrayList<CAPE>();
	private ArrayList<CAPE> acceptedFor = new ArrayList<CAPE>();
	private ArrayList<CAPE> conflicts = new ArrayList<CAPE>();
	private ArrayList<CAPE> alternates = new ArrayList<CAPE>();
	private Map<CAPE, Integer> pointMapping = new HashMap<CAPE, Integer>();
	private Map<CAPE, Map<String, String>> courseGrades = new HashMap<CAPE, Map<String, String>>();
	private ArrayList<CAPE> rejected = new ArrayList<CAPE>();
	private Map<CAPE, StatusMsg> reasons =  new HashMap<CAPE, StatusMsg>();

	
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
	
	public void clearMappings() {
		possibleSubjects = new ArrayList<CAPE>();
		acceptedFor = new ArrayList<CAPE>();
		conflicts = new ArrayList<CAPE>();
		alternates = new ArrayList<CAPE>();
		pointMapping = new HashMap<CAPE, Integer>();
		courseGrades = new HashMap<CAPE, Map<String, String>>();
		rejected = new ArrayList<CAPE>();
		reasons =  new HashMap<CAPE, StatusMsg>();
	}
	
	public Object[] calcPoints(CAPE cape) {
		//TODO change
		String primary = cape.getPrimary();
		String secondary = cape.getSecondary();
		String tertiary = cape.getTertiary();
		String reason = "";
		boolean hasTer = tertiary != null;
		boolean hasSec = secondary != null;
		boolean studHasPrim = false;
		boolean studHasSec = false;
		boolean studHasTer = false;
		
		int pGrade = -1;
		int sGrade = -1;
		int tGrade = -1;
		int totalPoints = 0;
		
		
		if (hasTer) {
			for (int i = 0; i < csecSubs.size(); i++) {
				String tName = csecSubs.get(i).getName();
				if (tName.equals(primary)) {
					pGrade = csecSubs.get(i).getGrade();
					studHasPrim = true;
				} 
				else if (tName.equals(secondary)) {
					sGrade = csecSubs.get(i).getGrade();
					studHasSec = true;
				} 
				else if (tName.equals(tertiary)) {
					tGrade = csecSubs.get(i).getGrade();
					studHasTer = true;
				} 
			}
		}
		else if (hasSec) {
			for (int i = 0; i < csecSubs.size(); i++) {
				String tName = csecSubs.get(i).getName();
				if (tName.equals(primary)) {
					pGrade = csecSubs.get(i).getGrade();
					studHasPrim = true;
				} 
				if (tName.equals(secondary)) {
					sGrade = csecSubs.get(i).getGrade();
					studHasSec = true;
				}
			}
		}
		else {
			for (int i = 0; i < csecSubs.size(); i++) {
				if (csecSubs.get(i).getName().equals(primary)) {
					pGrade = csecSubs.get(i).getGrade();
					studHasPrim = true;	
				} 
			}
		}
		Map<String, String> temp = new HashMap<String, String>();
		
		if (hasTer) {
			if (studHasTer && studHasPrim && studHasSec) {
				totalPoints += Point.getPoints("primary", pGrade) + Point.getPoints("tertiary", tGrade) + Point.getPoints("secondary", sGrade);
			}
			else if (!studHasPrim) {
				// TODO ADD MESSAGE FOR WHEN HE DOESN'T HAVE PRIMARY
				reason = "Primary Requirement not met";
			}
			else if (!studHasSec) {
				reason = "Secondary Requirement not met";
			}
			else {
				reason = "Tertiary Requirement not met";
			}
		}
		else if (hasSec) {
			if (studHasPrim && studHasSec) {
				totalPoints += Point.getPoints("primary", pGrade) + Point.getPoints("secondary", sGrade);
			}
			else if (!studHasPrim) {
				// TODO ADD MESSAGE FOR WHEN HE DOESN'T HAVE PRIMARY
				reason = "Primary Requirement not met";
			}
			else {
				reason = "Secondary Requirement not met";
			}
			
		}
		else {
			if (studHasPrim) {
				totalPoints += Point.getPoints("primary", pGrade);
			}
			else {
				reason = "Primary Requirement not met";
			}
		}
		//if (tGrade != -1 ) totalPoints += Point.getPoints("tertiary", tGrade);
		//else if (sGrade != -1 )	totalPoints += Point.getPoints("secondary", sGrade);	
	    //if (totalPoints == 0) System.out.println(this.toString() + "\t" + cape.getName() + ":\tPrimary Grade:\t" + pGrade + "\t" + totalPoints);
		if (pGrade != -1) temp.put("primary", Integer.toString(pGrade));
		else temp.put("primary", "");
		if (sGrade != -1) temp.put("secondary", Integer.toString(sGrade));
		else temp.put("secondary", "");
		if (tGrade != -1) temp.put("tertiary", Integer.toString(tGrade));
		else temp.put("tertiary", "");
		courseGrades.put(cape, temp);
		pointMapping.put(cape, totalPoints);
		Object [] result = {totalPoints, reason};
		return result;
		
	}
	
	public ArrayList<CAPE> getAcceptedFor() {
		return this.acceptedFor;
	}
	
	public ArrayList<CAPE> getConflictsSubs() {
		return this.conflicts;
	}
	
	public ArrayList<CAPE> getAlternateSubs() {
		return this.alternates;
	}
	

	public int getPoints(CAPE obj) {
		return pointMapping.get(obj);
	}
	
	public void addPossibleSub(CAPE subj) {
		possibleSubjects.add(subj);
		//reasons.put(subj, sMsg);
	}
	
	public Map<CAPE, StatusMsg> getReasons() {
		List<Entry<CAPE, StatusMsg>> list = new LinkedList<Entry<CAPE, StatusMsg>>(reasons.entrySet());
		
        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<CAPE, StatusMsg>>()
        {
            public int compare(Entry<CAPE, StatusMsg> o1,
                    Entry<CAPE, StatusMsg> o2)
            {
                    return o2.getValue().getStatus().compareTo(o1.getValue().getMsg());
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<CAPE, StatusMsg> sortedMap = new LinkedHashMap<CAPE, StatusMsg>();
        //System.out.println(super.name);
        for (Entry<CAPE, StatusMsg> entry : list)
        {
        	//System.out.print(entry.getKey().toString() + ": Points: " + entry.getValue() +"\t");
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        reasons = sortedMap;
		return this.reasons;
	}
	
	
	public boolean addAcceptedSubject(CAPE sub, StatusMsg sMsg, int max) {
		if ((max != 0) && (acceptedFor.size() == max)) {
			return false;
		}
		this.acceptedFor.add(sub);
		reasons.put(sub, sMsg);
		return true;
	}
	
	
	public String toString() {
		String tFName = (fName.substring(0, 1).toUpperCase()).concat(fName.substring(1));
		String tLName = (lName.substring(0, 1).toUpperCase()).concat(lName.substring(1));
		return tFName + " " + tLName;
	}


	public void addConflict(CAPE cape, StatusMsg sMsg) {
		conflicts.add(cape);
		reasons.put(cape, sMsg);	
	}


	public void addAlternate(CAPE cape, StatusMsg sMsg) {
		alternates.add(cape);
		reasons.put(cape, sMsg);
		
	}
	
	public void addRejected(CAPE c, StatusMsg sMsg) {
		this.rejected.add(c);
		reasons.put(c, sMsg);
	}
	
	public Map<String, String> getPreReqInfo(CAPE c) {
		return courseGrades.get(c);
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
		reasons.remove(c);
	}
}