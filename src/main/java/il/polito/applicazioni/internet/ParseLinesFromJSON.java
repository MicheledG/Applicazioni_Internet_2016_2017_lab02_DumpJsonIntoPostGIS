package il.polito.applicazioni.internet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import il.polito.applicazioni.internet.json.model.LinesClass;

public class ParseLinesFromJSON {

	public static LinesClass parse() {
		
		
		LinesClass lines = null;
		
		ClassLoader classLoader = ParseLinesFromJSON.class.getClassLoader();
		File file = new File(classLoader.getResource("linee.json").getFile());
		FileReader fileReader = null;
		
		try {
			 fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		lines = gson.fromJson(fileReader, LinesClass.class);
		
//		for (LineClass line : lines.getLines()) {
//			System.out.println("==================");
//			System.out.println("Line name: "+line.getLine());
//			System.out.println("Line description: "+line.getDesc());
//			System.out.println("Line stops:");
//			int i = 1;
//			for (String stop : line.getStops()) {
//				System.out.println("Stop nr. "+i+": "+stop);
//				i++;
//			}
//			System.out.println("==================");
//		}
//		
//		for (StopClass stop: lines.getStops()) {
//			System.out.println("==================");
//			System.out.println("Stop id: "+stop.getId());
//			System.out.println("Stop name: "+stop.getName());
//			System.out.println("Stop latitude: "+stop.getLatLng().get(0));
//			System.out.println("Stop longitude: "+stop.getLatLng().get(1));
//			System.out.println("Lines:");
//			for (String line: stop.getLines()) {
//				System.out.println("- "+line);
//			}
//			System.out.println("==================");
//		}
		
		
		try {
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
		}
		
		return lines;
		
	}

}
