package SQL;
import Security.Crypto;

public class MainStudentsCalls {
  public static void main(String[] args) throws Exception {
	//  AccessStudentsCalls db = new AccessStudentsCalls();
	  String pass = (AccessDatabase.getUsers()).get("Admin");
	  System.out.println(pass);
  }

}