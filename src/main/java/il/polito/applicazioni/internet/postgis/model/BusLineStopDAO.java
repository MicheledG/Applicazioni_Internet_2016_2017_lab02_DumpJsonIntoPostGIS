package il.polito.applicazioni.internet.postgis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusLineStopDAO {

	public static void createBusLineStop(Connection connection, BusLineStop busLineStop){
		
		PreparedStatement preparedStatement = null;
		
		try{
			String query = "INSERT INTO buslinestop "
					+ "VALUES( "
					+ "?, "
					+ "?, "
					+ "? "
					+ ");";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, busLineStop.getStopId());
			preparedStatement.setString(2, busLineStop.getLineId());
			preparedStatement.setInt(3, busLineStop.getSequenceNumber());
			
			int newRows = preparedStatement.executeUpdate();
			
			System.out.println("Number of rows changed into BusLineStop table: "+newRows);
			
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
