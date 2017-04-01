package il.polito.applicazioni.internet.json.model;

import java.util.List;

public class LinesClass {

	private List<LineClass> lines;
	private List<StopClass> stops;
	public List<LineClass> getLines() {
		return lines;
	}
	public void setLines(List<LineClass> lines) {
		this.lines = lines;
	}
	public List<StopClass> getStops() {
		return stops;
	}
	public void setStops(List<StopClass> stops) {
		this.stops = stops;
	}
	
	
}
