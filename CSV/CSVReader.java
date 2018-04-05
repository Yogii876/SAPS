import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "/Users/Karishma Mirpuri/Downloads/students.csv";
        String filename = "/Users/Karishma Mirpuri/Downloads/input_file.sql";
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
                    writer.write("\nINSERT INTO GRADE(StudID,SubjNum,Grade) VALUES(" + id_num + "," + getCsecCode((grade_info[gIndex]).trim()) + ", " + grade_info[gIndex+1] + ");");
                    gIndex += 2;                    
                }
                count = 0;
                gIndex = 0;
                String[] sel_info = line.split("/")[2].split(cvsSplitBy);
                //writer.write("\nINSERT INTO STUD_SEL VALUES(" + id_num + "," + getCapeCode((sel_info[2])) + ");");
                while(count < sel_info.length) {
                	writer.write("\nINSERT INTO STUD_SEL(StudID, SubjNum) VALUES(" + id_num + "," + getCapeCode((sel_info[count])) + ");");
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
    
    public static int getCapeCode(String subj){
        int code;
        if (subj.compareTo("ACCOUNTING") == 0) code = 1;
        else if (subj.compareTo("ANIMATION & GAME DESIGN") == 0) code = 2;
        else if (subj.compareTo("AGRICULTURAL SCIENCE") == 0) code = 3;
        else if (subj.compareTo("APPLIED MATHEMATICS") == 0) code = 4;
        else if (subj.compareTo("ART AND DESIGN") == 0) code = 5;
        else if (subj.compareTo("BIOLOGY") == 0) code = 6;
        else if (subj.compareTo("BUILDING AND MECHANICAL ENGINEERING DRAWING") == 0) code = 7;
        else if (subj.compareTo("CARIBBEAN STUDIES") == 0) code = 8;
        else if (subj.compareTo("CHEMISTRY") == 0) code = 9;
        else if (subj.compareTo("COMMUNICATION STUDIES") == 0) code = 10;
        else if (subj.compareTo("COMPUTER SCIENCE") == 0) code = 11;
        else if (subj.compareTo("DIGITAL MEDIA") == 0) code = 12;
        else if (subj.compareTo("ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY") == 0) code = 13;
        else if (subj.compareTo("ECONOMICS") == 0) code = 14;
        else if (subj.compareTo("ENTREPRENEURSHIP") == 0) code = 15;
        else if (subj.compareTo("ENVIRONMENTAL SCIENCE") == 0) code = 16;
        else if (subj.compareTo("FINANCIAL SERVICES STUDIES") == 0) code = 17;
        else if (subj.compareTo("FOOD AND NUTRITION") == 0) code = 18;
        else if (subj.compareTo("FRENCH") == 0) code = 19;
        else if (subj.compareTo("GEOGRAPHY") == 0) code = 20;
        else if (subj.compareTo("GREEN ENGINEERING") == 0) code = 21;
        else if (subj.compareTo("HISTORY") == 0) code = 22;
        else if (subj.compareTo("INFORMATION TECHNOLOGY") == 0) code = 23;
        else if (subj.compareTo("INTEGRATED MATHEMATICS") == 0) code = 24;
        else if (subj.compareTo("LAW") == 0) code = 25;
        else if (subj.compareTo("LITERATURES IN ENGLISH") == 0) code = 26;
        else if (subj.compareTo("LOGISTICS AND SUPPLY CHAIN OPERATIONS") == 0) code = 27;
        else if (subj.compareTo("MANAGEMENT OF BUSINESS") == 0) code = 28;
        else if (subj.compareTo("PERFORMING ARTS") == 0) code = 29;
        else if (subj.compareTo("PHYSICS") == 0) code = 30;
        else if (subj.compareTo("PHYSICAL EDUCATION AND SPORT") == 0) code = 31;
        else if (subj.compareTo("PURE MATHEMATICS") == 0) code = 32;
        else if (subj.compareTo("SOCIOLOGY") == 0) code = 33;
        else if (subj.compareTo("SPANISH") == 0) code = 34;
        else if (subj.compareTo("TOURISM") == 0) code = 35;
        else code = 0; //what to do here
        return code;
    }
    
    public static String getCapeCode(int code){
        String subj;
        if (code == 1) subj = "ACCOUNTING";
        else if (code == 2) subj = "ANIMATION & GAME DESIGN";
        else if (code == 3) subj = "AGRICULTURAL SCIENCE";
        else if (code == 4) subj = "APPLIED MATHEMATICS";
        else if (code == 5) subj = "ART AND DESIGN";
        else if (code == 6) subj = "BIOLOGY";
        else if (code == 7) subj = "BUILDING AND MECHANICAL ENGINEERING DRAWING";
        else if (code == 8) subj = "CARIBBEAN STUDIES";
        else if (code == 9) subj = "CHEMISTRY";
        else if (code == 10) subj = "COMMUNICATION STUDIES";
        else if (code == 11) subj = "COMPUTER SCIENCE";
        else if (code == 12) subj = "DIGITAL MEDIA";
        else if (code == 13) subj = "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY";
        else if (code == 14) subj = "ECONOMICS";
        else if (code == 15) subj = "ENTREPRENEURSHIP";
        else if (code == 16) subj = "ENVIRONMENTAL SCIENCE";
        else if (code == 17) subj = "FINANCIAL SERVICES STUDIES";
        else if (code == 18) subj = "FOOD AND NUTRITION";
        else if (code == 19) subj = "FRENCH";
        else if (code == 20) subj = "GEOGRAPHY";
        else if (code == 21) subj = "GREEN ENGINEERING";
        else if (code == 22) subj = "HISTORY";
        else if (code == 23) subj = "INFORMATION TECHNOLOGY";
        else if (code == 24) subj = "INTEGRATED MATHEMATICS";
        else if (code == 25) subj = "LAW";
        else if (code == 26) subj = "LITERATURES IN ENGLISH";
        else if (code == 27) subj = "LOGISTICS AND SUPPLY CHAIN OPERATIONS";
        else if (code == 28) subj = "MANAGEMENT OF BUSINESS";
        else if (code == 29) subj = "PERFORMING ARTS";
        else if (code == 30) subj = "PHYSICS";
        else if (code == 31) subj = "PHYSICAL EDUCATION AND SPORT";
        else if (code == 32) subj = "PURE MATHEMATICS";
        else if (code == 33) subj = "SOCIOLOGY";
        else if (code == 34) subj = "SPANISH";
        else if (code == 35) subj = "TOURISM";
        else subj = "ERROR";
        return subj;
    }
    
    public static int getCsecCode(String subj){
        int code;
        if (subj.compareTo("ADDITIONAL MATHEMATICS") == 0) code = 1;
        else if (subj.compareTo("AGRICULTURAL SCIENCE") == 0) code = 2;
        else if (subj.compareTo("BIOLOGY") == 0) code = 3;
        else if (subj.compareTo("CARIBBEAN HISTORY") == 0) code = 4;
        else if (subj.compareTo("CHEMISTRY") == 0) code = 5;
        else if (subj.compareTo("ECONOMICS") == 0) code = 6;
        else if (subj.compareTo("ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT") == 0) code = 7;
        else if (subj.compareTo("ENGLISH A") == 0) code = 8;
        else if (subj.compareTo("ENGLISH B") == 0) code = 9;
        else if (subj.compareTo("FAMILY AND RESOURCE MANAGEMENT") == 0) code = 10;
        else if (subj.compareTo("FOOD, NUTRITION AND HEALTH") == 0) code = 11;
        else if (subj.compareTo("FRENCH") == 0) code = 12;
        else if (subj.compareTo("GEOGRAPHY") == 0) code = 13;
        else if (subj.compareTo("HOME ECONOMICS") == 0) code = 14;
        else if (subj.compareTo("HUMAN AND SOCIAL BIOLOGY") == 0) code = 15;
        else if (subj.compareTo("INDUSTRIAL TECHNOLOGY") == 0) code = 16;
        else if (subj.compareTo("INFORMATION TECHNOLOGY") == 0) code = 17;
        else if (subj.compareTo("INTEGRATED SCIENCE") == 0) code = 18;
        else if (subj.compareTo("MATHEMATICS") == 0) code = 19;
        else if (subj.compareTo("MUSIC") == 0) code = 20;
        else if (subj.compareTo("OFFICE ADMINISTRATION") == 0) code = 21;
        else if (subj.compareTo("PHYSICAL EDUCATION AND SPORT") == 0) code = 22;
        else if (subj.compareTo("PHYSICS") == 0) code = 23;
        else if (subj.compareTo("PORTUGUESE") == 0) code = 24;
        else if (subj.compareTo("PRINCIPLES OF ACCOUNTS") == 0) code = 25;
        else if (subj.compareTo("PRINCIPLES OF BUSINESS") == 0) code = 26;
        else if (subj.compareTo("RELIGIOUS EDUCATION") == 0) code = 27;
        else if (subj.compareTo("SOCIAL STUDIES") == 0) code = 28;
        else if (subj.compareTo("SPANISH") == 0) code = 29;
        else if (subj.compareTo("TECHNICAL DRAWING") == 0) code = 30;
        else if (subj.compareTo("TEXTILES, CLOTHING AND FASHION") == 0) code = 31;
        else if (subj.compareTo("THEATRE ARTS") == 0) code = 32;
        else if (subj.compareTo("VISUAL ARTS") == 0) code = 33;
        else code = 0; //error?
        return code;
        }
   

public static String getCsecCode(int code){
    String subj;
    if (code == 1) subj = "ADDITIONAL MATHEMATICS";
    else if (code == 2) subj = "AGRICULTURAL SCIENCE";
    else if (code == 3) subj = "BIOLOGY";
    else if (code == 4) subj = "CARIBBEAN HISTORY";
    else if (code == 5) subj = "CHEMISTRY";
    else if (code == 6) subj = "ECONOMICS";
    else if (code == 7) subj = "ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT";
    else if (code == 8) subj = "ENGLISH A";
    else if (code == 9) subj = "ENGLISH B";
    else if (code == 10) subj = "FAMILY AND RESOURCE MANAGEMENT";
    else if (code == 11) subj = "FOOD, NUTRITION AND HEALTH";
    else if (code == 12) subj = "FRENCH";
    else if (code == 13) subj = "GEOGRAPHY";
    else if (code == 14) subj = "HOME ECONOMICS";
    else if (code == 15) subj = "HUMAN AND SOCIAL BIOLOGY";
    else if (code == 16) subj = "INDUSTRIAL TECHNOLOGY";
    else if (code == 17) subj = "INFORMATION TECHNOLOGY";
    else if (code == 18) subj = "INTEGRATED SCIENCE";
    else if (code == 19) subj = "MATHEMATICS";
    else if (code == 20) subj = "MUSIC";
    else if (code == 21) subj = "OFFICE ADMINISTRATION";
    else if (code == 22) subj = "PHYSICAL EDUCATION AND SPORT";
    else if (code == 23) subj = "PHYSICS";
    else if (code == 24) subj = "PORTUGUESE";
    else if (code == 25) subj = "PRINCIPLES OF ACCOUNTS";
    else if (code == 26) subj = "PRINCIPLES OF BUSINESS";
    else if (code == 27) subj = "RELIGIOUS EDUCATION";
    else if (code == 28) subj = "SOCIAL STUDIES";
    else if (code == 29) subj = "SPANISH";
    else if (code == 30) subj = "TECHNICAL DRAWING";
    else if (code == 31) subj = "TEXTILES, CLOTHING AND FASHION";
    else if (code == 32) subj = "THEATRE ARTS";
    else if (code == 33) subj = "VISUAL ARTS";
    else subj = "ERROR";
    return subj;
    }
}

