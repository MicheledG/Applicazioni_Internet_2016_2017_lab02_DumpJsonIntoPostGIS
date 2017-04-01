package il.polito.applicazioni.internet.postgis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusLineDAO {
	
	public static void createBusLine(Connection connection, BusLine busLine){
		
		PreparedStatement preparedStatement = null;
		
		try{
			String query = "INSERT INTO BusLine "
					+ "VALUES( "
					+ "?, "
					+ "? "
					+ ");";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, busLine.getLine());
			preparedStatement.setString(2, busLine.getDescription());
			
			int newRows = preparedStatement.executeUpdate();
			
			System.out.println("Number of rows changed into BusLine table: "+newRows);
			
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
	
}
