package CSV;

import Core.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Exception;


public class Reader {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<CSEC> csecSubs = new ArrayList<CSEC>();
	private ArrayList<String> capeSubs = new ArrayList<String>();
	
	public Reader(File csvFile) throws Exception {
		//String csvFile = filePath;
		if (csvFile.canRead()) {
			
			BufferedReader br = null;
		    String line = "";
		    String cvsSplitBy = ",";
		    String courseSplitBy = "/";
		    try {
		    	int id_num = 1;
		        br = new BufferedReader(new FileReader(csvFile));
		        while ((line = br.readLine()) != null) {
		        	line = line.trim();
		            String[] stud_info = line.split(cvsSplitBy);
		            String fName = stud_info[0].trim(), lName = stud_info[1].trim();               
		            String[] grade_info = line.split(courseSplitBy)[1].split(cvsSplitBy);
		            int grade_length = grade_info.length;
		            int noTime = grade_length / 2;
		            int count = 0;
		            int gIndex = 0;
		            csecSubs = new ArrayList<CSEC>();
		            while (count < noTime) {
		                count++;
		                System.out.print(grade_info[gIndex+1]);
		                csecSubs.add(new CSEC(((grade_info[gIndex]).trim()).toLowerCase(), Integer.parseInt(grade_info[gIndex+1].trim())));
		                gIndex += 2;                    
		            }
		            count = 0;
		            gIndex = 0;
		            String[] sel_info = line.split("/")[2].split(cvsSplitBy);
		            while(count < sel_info.length) {
		            	capeSubs.add((sel_info[count].trim()).toLowerCase());
		            	count++;
		            }
		            students.add(new Student(id_num,fName, lName, csecSubs, capeSubs));
		            String sid = Integer.toString(students.get(id_num-1).getSid());
		            System.out.println(sid + " " + students.get(id_num-1).getFirstName() + " " + students.get(id_num-1).getLastName()+" "+students.get(id_num-1).getCSEC().get(0).getName()+" "+students.get(id_num-1).getCSEC().get(4).getName());
		            id_num++;
		            
		          
		
		        }
		    }
		    catch (Exception e) {
		    	throw new Exception("Error while parsing file, please sure values are stored in a comma-separated format");
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
	
	public ArrayList<Student> getStudents() {
		return this.students;
	}
}