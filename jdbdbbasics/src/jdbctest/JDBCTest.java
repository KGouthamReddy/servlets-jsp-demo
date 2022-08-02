package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		
		//insertIntoDB();
		//updateDB();
		//deleteDB();
		readFromDB();
		
		
		
	}	
	private static void readFromDB() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");		
		Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery("select * from account");
		while(resultset.next()) {
			System.out.println(resultset.getInt(1) + "  " + resultset.getString(2) + "  " + resultset.getString(3) + "  " + resultset.getLong(4));
			
		}
		statement.close();
		connection.close();
	}
	private static void insertIntoDB() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
		Statement statement = con.createStatement();
		//int rowsInserted = statement.executeUpdate("insert into account values (6, 'mary', 'jane', 80000)");
		//System.out.println("Number of rows inserted: " + rowsInserted);
	}
	private static void updateDB() throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
		Statement statement = connection.createStatement();
		//int rowsUpdated = statement.executeUpdate("update account set balance=150000 where accountNo=3");
		//System.out.println("Number of rows Updated: " + rowsUpdated);
	}
	private static void deleteDB() throws SQLException{
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
		Statement statement = connection.createStatement();
		int rowsDeleted = statement.executeUpdate("delete from account where firstname='alen'");
		System.out.println("Number of rows deleted: " + rowsDeleted);
		
	}
}
