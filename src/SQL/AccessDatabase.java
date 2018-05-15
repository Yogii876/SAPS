package SQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class AccessDatabase {

	private static Connection connect = null;
	private static Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	final private static String host = "localhost";
	final private static String user = "root";
	final private static String passwd = "";
	final private static String database = "saps";

	public static void connectToDB() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
					+ database + "?" + "user=" + user + "&password=" + passwd);

		} catch (Exception e) {
			throw e;
		}
	}

	/*public void readStudents() throws Exception {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from " + database + ".students");
			while (resultSet.next()) {
				int Id = resultSet.getInt("Id");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");

				System.out.println(String.format(
						"Id: %d name: %5s  phone: %5s", Id, name, phone));
			}
		} catch (Exception e) {
			throw e;
		}
	}*/
	
	public static Map<String, String> getUsers() throws Exception {
		connectToDB();
		try {
			Map<String, String> userResults = new HashMap<String, String>();
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select user, password from " + "users");
			while (resultSet.next()) {
				String user = (resultSet.getString("user")).trim();
				String password = (resultSet.getString("password")).trim();
				userResults.put(user, password);
			}
			close();
			return userResults;
			}
		catch (Exception e) {
			throw new Exception("Error reading users from database, please try again");
		}
		
		
	}
	
	public static void addUsers(String name, String password) throws Exception {
		try {
			statement = connect.createStatement();
			//String[] test =  {"saps.users.user", "saps.users.password"};
			statement
				.executeUpdate("INSERT INTO users(user, password) VALUES('" + name + "','" + password +"');");
			//statement.executeQuery("use " + database + ".users;insert into users values (" + name + "," + password + ");");
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("Error reading users from database, please try again");
		}
		
		
	}
	

	// You need to close the resultSet
	private static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}