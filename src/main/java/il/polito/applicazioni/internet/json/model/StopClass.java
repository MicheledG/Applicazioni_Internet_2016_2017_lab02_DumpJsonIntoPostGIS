package il.polito.applicazioni.internet.json.model;

import java.util.List;

public class StopClass {

	private String id;
	private String name;
	private List<Double> latLng;
	private List<String> lines;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Double> getLatLng() {
		return latLng;
	}
	public void setLatLng(List<Double> latLng) {
		this.latLng = latLng;
	}
	public List<String> getLines() {
		return lines;
	}
	public void setLines(List<String> lines) {
		this.lines = lines;
	}
	
}
