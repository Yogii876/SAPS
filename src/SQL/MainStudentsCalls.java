package SQL;
import Security.Crypto;

public class MainStudentsCalls {
  public static void main(String[] args) throws Exception {
	  AccessStudentsCalls db = new AccessStudentsCalls();
	  db.connectToDB();
	  int password = Crypto.encrypt("Admin", "Administrator");
	  System.out.println(password);
	  //db.addUsers("Admin", password);
	  int pass = Integer.parseInt((db.getUsers().get("Admin")));
	  System.out.println(Crypto.decrypt("Admin", pass));
	  
	  db.close();
  }

}