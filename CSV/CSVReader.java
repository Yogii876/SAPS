package CSV;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReader {

    //public static void main(String[] args) {
	public CSVReader(String filePath) {

        //String csvFile = "/Users/Karishma Mirpuri/Downloads/students.csv";
		String csvFile = filePath;
        String filename = "/Users/Karishma Mirpuri/Desktop/input_file.sql";
        //find a way to output on any desktop
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        try {
        	int id_num = 1;
            br = new BufferedReader(new FileReader(csvFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            while ((line = br.readLine()) != null) {
            	line = line.trim();
                String[] stud_info = line.split(cvsSplitBy);
                writer.write("\nINSERT INTO STUDENT(StudID,Fname,Lname) VALUES(" + id_num + ", '" + stud_info[0] + "', '" + stud_info[1] + "');");
                String[] grade_info = line.split("/")[1].split(cvsSplitBy);
                int grade_length = grade_info.length;
                int noTime = grade_length / 2;
                int count = 0;
                int gIndex = 0;
                while (count < noTime) {
                    count++;
                    writer.write("\nINSERT INTO GRADE(StudID,SubjNum,Grade) VALUES(" + id_num + "," + CourseCode.getCsecCode(((grade_info[gIndex]).trim())) + ", " + grade_info[gIndex+1] + ");");
                    gIndex += 2;                    
                }
                count = 0;
                gIndex = 0;
                String[] sel_info = line.split("/")[2].split(cvsSplitBy);
                //writer.write("\nINSERT INTO STUD_SEL VALUES(" + id_num + "," + getCapeCode((sel_info[2])) + ");");
                while(count < sel_info.length) {
                	writer.write("\nINSERT INTO STUD_SEL(StudID, SubjNum) VALUES(" + id_num + "," + CourseCode.getCapeCode(((sel_info[count]))) + ");");
                	count++;
                }
                id_num++;
              

            }
            writer.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

