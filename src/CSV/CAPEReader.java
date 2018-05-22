package CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Core.CAPE;


public class CAPEReader {
	private ArrayList<CAPE> subjects = new ArrayList<CAPE>();
	private Map<String, CAPE> subMap = new HashMap<String, CAPE>();
	private String prim, sec, ter = null;
	
	public CAPEReader(File subFile) throws Exception {
		//String subFile = filePath;
		if (subFile.canRead()) {
			
			BufferedReader br = null;
		    String line = "";
		    String courseSplitBy = ",,";
		    try {
		    	//int id_num = 1;
		        br = new BufferedReader(new FileReader(subFile));
		        while ((line = br.readLine()) != null) {
		        	prim = null;
		        	sec = null;
		        	ter = null;
		        	line = line.trim();
		            String[] courseInfo = line.split(",,");
		            String sName = (courseInfo[0].trim()).toLowerCase();             
		            String[] req_info = line.split(",,")[1].split(",");
		            int count = 0;
		            while (count < req_info.length) {
		                if (count == 0) {
		                	prim = req_info[count];
		                }
		                else if (count == 1) {
		                	sec = req_info[count];
		                }
		                else if (count == 2) {
		                	ter = req_info[count];
		                }
		                count++;
		            }
		            CAPE sub;
		            //TODO create 
		            if (prim != null) {
		            	sub = populateSubjects(sName, prim, sec, ter, Integer.parseInt(line.split(",,")[3]));
		            	subjects.add(sub);
		            	}
		            else {
		            	break;
		            }
		            String[] antis = line.split(",,")[2].split(",");
		            count = 0;
		            while (count < antis.length) {
		                sub.addAntiReq(antis[count]);
		                count++;
		            }
		        }
		    }
		    catch (Exception e) {
		    	//throw new Exception("Error while parsing file, please sure values are stored in a comma-separated format");
		    	e.printStackTrace();
		    }
		    finally {
		        if (br != null) {
		            try {
		                br.close();
		            } catch (IOException e) {
		            }
		        }
		    }
		}
		else {
			throw new Exception("Unable to read file");
		}

    }

	public CAPE populateSubjects(String name, String pReq, String sReq, String tReq, int maxStud) {
		CAPE subj;
		if (tReq != null) {
			subj = new CAPE(name, pReq, sReq, tReq, maxStud);
		}
		else if (sReq != null) {
			subj = new CAPE(name, pReq, sReq, maxStud);
		}
		else {
			subj = new CAPE(name, pReq, maxStud);
		}
		subMap.put(subj.getName(), subj);
		return subj;
	}
	
	
	
	
	public Map<String, CAPE> getMap() {
		return subMap;
	}
	
	public ArrayList<CAPE> getStudents() {
		return this.subjects;
	}
}