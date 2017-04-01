package il.polito.applicazioni.internet.postgis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusStopDAO {

	public static void createBusLineStop(Connection connection, BusStop busStop){
		
		PreparedStatement preparedStatement = null;
		
		try{
			String query = "INSERT INTO busstop "
					+ "VALUES( "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "? "
					+ ");";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, busStop.getId());
			preparedStatement.setString(2, busStop.getName());
			preparedStatement.setDouble(3, busStop.getLat());
			preparedStatement.setDouble(4, busStop.getLng());
			
			int newRows = preparedStatement.executeUpdate();
			
			System.out.println("Number of rows changed into BusStop table: "+newRows);
			
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
