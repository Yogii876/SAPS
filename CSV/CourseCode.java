package CSV;

public class CourseCode {
	
	public static int getCsecCode(String subj){
        int code;
        if (subj.compareTo("ADDITIONAL MATHEMATICS") == 0) code = 1;
        else if (subj.compareTo("AGRICULTURAL SCIENCE") == 0) code = 2;
        else if (subj.compareTo("BIOLOGY") == 0) code = 3;
        else if (subj.compareTo("CARIBBEAN HISTORY") == 0) code = 4;
        else if (subj.compareTo("CERTIFICATE IN BUSINESS STUDIES") == 0) code = 5;
        else if (subj.compareTo("CHEMISTRY") == 0) code = 6;
        else if (subj.compareTo("ECONOMICS") == 0) code = 7;
        else if (subj.compareTo("ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT") == 0) code = 8;
        else if (subj.compareTo("ENGLISH A") == 0) code = 9;
        else if (subj.compareTo("ENGLISH B") == 0) code = 10;
        else if (subj.compareTo("GEOGRAPHY") == 0) code = 11;
        else if (subj.compareTo("HOME ECONOMICS") == 0) code = 12;
        else if (subj.compareTo("HUMAN AND SOCIAL BIOLOGY") == 0) code = 13;
        else if (subj.compareTo("INDUSTRIAL TECHNOLOGY") == 0) code = 14;
        else if (subj.compareTo("INFORMATION TECHNOLOGY") == 0) code = 15;
        else if (subj.compareTo("INTEGRATED SCIENCE") == 0) code = 16;
        else if (subj.compareTo("MATHEMATICS") == 0) code = 17;
        else if (subj.compareTo("MODERN LANGUAGES") == 0) code = 18;
        else if (subj.compareTo("MUSIC") == 0) code = 19;
        else if (subj.compareTo("PHYSICAL EDUCATION AND SPORT") == 0) code = 20;
        else if (subj.compareTo("PHYSICS") == 0) code = 21;
        else if (subj.compareTo("PRINCIPLES OF ACCOUNTS") == 0) code = 22;
        else if (subj.compareTo("PRINCIPLES OF BUSINESS") == 0) code = 23;
        else if (subj.compareTo("RELIGIOUS EDUCATION") == 0) code = 24;
        else if (subj.compareTo("SOCIAL STUDIES") == 0) code = 25;
        else if (subj.compareTo("TECHNICAL DRAWING") == 0) code = 26;
        else if (subj.compareTo("THEATRE ARTS") == 0) code = 27;
        else if (subj.compareTo("VISUAL ARTS") == 0) code = 28;
        else code = 0; //error?
        return code;
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

}
