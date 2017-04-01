package il.polito.applicazioni.internet;

import java.util.ArrayList;
import java.util.List;

import il.polito.applicazioni.internet.json.model.LineClass;
import il.polito.applicazioni.internet.json.model.LinesClass;
import il.polito.applicazioni.internet.json.model.StopClass;
import il.polito.applicazioni.internet.postgis.model.BusLine;
import il.polito.applicazioni.internet.postgis.model.BusLineStop;
import il.polito.applicazioni.internet.postgis.model.BusStop;

public class JSON2PostGISTranslator {
	
	public static void main(String[] args){
		
		LinesClass lines = ParseLinesFromJSON.parse();
		
		if(lines==null){
			System.out.println("Impossible to parse lines from json file");
			return;
		}
		
		//translate json model to post gis model
		List<BusLine> busLineList = new ArrayList<>();
		List<BusStop> busStopList = new ArrayList<>();
		List<BusLineStop> busLineStopList = new ArrayList<>();
		
		
		for (LineClass line : lines.getLines()) {
			BusLine busLine = new BusLine();
			busLine.setLine(line.getLine());
			busLine.setDescription(line.getDesc());
			
			System.out.println("==================");
			System.out.println("BusLine line: "+busLine.getLine());
			System.out.println("BusLine description: "+busLine.getDescription());		
			System.out.println("==================");
			
			busLineList.add(busLine);
			
			int sequenceNumber = 1;
			for (String stop : line.getStops()) {
				BusLineStop busLineStop = new BusLineStop(); 
				busLineStop.setLineId(line.getLine());
				busLineStop.setStopId(stop);
				busLineStop.setSequenceNumber(sequenceNumber);
				sequenceNumber++;
				
				System.out.println("==================");
				System.out.println("BusLineStop lineId: "+busLineStop.getLineId());
				System.out.println("BusLineStop stopId: "+busLineStop.getStopId());
				System.out.println("BusLineStop sequenceNumber: "+busLineStop.getSequenceNumber());		
				System.out.println("==================");
				
				busLineStopList.add(busLineStop);
			}
		}
		
		for (StopClass stop: lines.getStops()) {
			BusStop busStop = new BusStop();
			busStop.setId(stop.getId());
			busStop.setName(stop.getName());
			busStop.setLat(stop.getLatLng().get(0));
			busStop.setLng(stop.getLatLng().get(1));
			
			System.out.println("==================");
			System.out.println("BusStop id: "+busStop.getId());
			System.out.println("BusStop name: "+busStop.getName());
			System.out.println("BusStop lat: "+busStop.getLat());
			System.out.println("BusStop lng: "+busStop.getLng());
			System.out.println("==================");
			
			busStopList.add(busStop);
		}
		
		
		//load post gis model to post gis DB
	}
	
}
