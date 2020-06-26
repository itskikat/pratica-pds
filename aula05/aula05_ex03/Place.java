package aula05_Movie;

public class Place {
	private String location;
	
	public Place(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		String out = "";
		out += "LOCATION [location: " + location + "]";
		return out;
	}
}
