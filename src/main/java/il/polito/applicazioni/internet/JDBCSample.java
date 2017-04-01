package il.polito.applicazioni.internet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCSample {
	
	private static final String SERVER_ADDRESS = "192.168.99.100";
	private static final String SERVER_PORT = "5432";
	private static final String DB_NAME = "postgres";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "ai-user-password";
	
	public static void main(String[] args) {
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		
		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://"+SERVER_ADDRESS+":"+SERVER_PORT+"/"+DB_NAME,
					DB_USERNAME,
					DB_PASSWORD);
			
			System.out.println("Connected to PostGIS!");
			
			DropPersonsTable(connection);
			CreatePersonsTable(connection);
			
			for(int i = 0; i<10; i++){
				String name = "michele";
				String surname = "di girolamo";
				InsertPerson(connection, name, surname);
			}
			
			List<Integer> personIDs = SelectAllPersonIDs(connection);
			
			for (Integer id : personIDs) {
				System.out.println("Person id: "+id);
			}
			
			
		} catch (Exception e) {
			
		
		} finally {
			
			try{
				if(connection!= null) connection.close();
			}catch (Exception e) {
				System.out.println("Exception closing Connection: "+e.getMessage());
			}
		
		}
		
		
		return;
	}
	
	private static void DropPersonsTable(Connection connection){
		
		Statement statement = null;
		
		try {
			String query = "DROP TABLE  persons;";
			
			statement = connection.createStatement();
			int newRows = statement.executeUpdate(query);
			
			System.out.println("Number of rows changed into db '"+DB_NAME+"': "+newRows);
		
		} catch (SQLException e) {

			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();

		} finally {
		
			try{
				if(statement!= null) statement.close();
			}catch (Exception e) {
				System.out.println("Exception closing Statement: "+e.getMessage());
			}
		}	
	}
	
	
	private static void CreatePersonsTable(Connection connection){
		
		Statement statement = null;
		
		try {
			String query = "CREATE TABLE persons("
					+ "id SERIAL, "
					+ "name varchar(255), "
					+ "surname varchar(255), "
					+ "PRIMARY KEY (id)"
					+ ");";
			
			statement = connection.createStatement();
			int newRows = statement.executeUpdate(query);
			
			System.out.println("Number of rows changed into db '"+DB_NAME+"': "+newRows);
		
		} catch (SQLException e) {

			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();

		} finally {
		
			try{
				if(statement!= null) statement.close();
			}catch (Exception e) {
				System.out.println("Exception closing Statement: "+e.getMessage());
			}
		}	
	}
	
	private static void InsertPerson(Connection connection, String name, String surname){
		
		PreparedStatement preparedStatement = null;
		
		try{
			String query = "INSERT INTO persons( "
					+ "name, "
					+ "surname "
					+ ") "
					+ "VALUES( "
					+ "?, "
					+ "? "
					+ ");";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			
			int newRows = preparedStatement.executeUpdate();
			
			System.out.println("Number of rows changed into db '"+DB_NAME+"': "+newRows);
		
		} catch (SQLException e) {

		System.out.println("Exception: "+e.getMessage());
		e.printStackTrace();

		} finally {
		
			try{
				if(preparedStatement!= null) preparedStatement.close();
			}catch (Exception e) {
				System.out.println("Exception closing PreaparedStatement: "+e.getMessage());
			}
		}
	}
	
	private static List<Integer> SelectAllPersonIDs(Connection connection) {
		
		List<Integer> ids = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try{
			String attributeName = "id";
			String query = "SELECT "+ attributeName +" FROM persons;";
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(query);
			
			ids = new ArrayList<Integer>();
			
			while(resultSet.next()){
				ids.add(resultSet.getInt(attributeName));
			}
			
		
		} catch (SQLException e) {

		System.out.println("Exception: "+e.getMessage());
		e.printStackTrace();

		} finally {
		
			try{
				if(statement!= null) statement.close();
			}catch (Exception e) {
				System.out.println("Exception closing Statement: "+e.getMessage());
			}
		}
		
		return ids;
		
	}
	
}
