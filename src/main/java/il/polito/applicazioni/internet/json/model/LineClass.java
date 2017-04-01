package il.polito.applicazioni.internet.json.model;

import java.util.List;

public class LineClass {

	private String line;
	private String desc;
	private List<String> stops;
	
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<String> getStops() {
		return stops;
	}
	public void setStops(List<String> stops) {
		this.stops = stops;
	}
	
}
