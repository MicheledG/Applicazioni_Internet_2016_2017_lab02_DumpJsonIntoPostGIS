package il.polito.applicazioni.internet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JSONParserFromFileSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader classLoader = JSONParserFromFileSample.class.getClassLoader();
		File file = new File(classLoader.getResource("linee.json").getFile());
		
		try (Scanner scanner = new Scanner(file)) {
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
