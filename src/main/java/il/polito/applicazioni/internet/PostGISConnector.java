package il.polito.applicazioni.internet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostGISConnector {
	
	private static final String SERVER_ADDRESS = "192.168.99.100";
	private static final String SERVER_PORT = "5432";
	private static final String DB_NAME = "trasporti";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "ai-user-password";
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return null;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");
		
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://"+SERVER_ADDRESS+":"+SERVER_PORT+"/"+DB_NAME,
					DB_USERNAME,
					DB_PASSWORD);
			
			System.out.println("Connected to PostGIS!");
			return connection;
			
		} catch (SQLException e) {
			return null;
		}
		
	}	
}
