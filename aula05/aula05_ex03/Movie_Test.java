package aula05_Movie;

import java.util.*;

public class Movie_Test {
	
	public static void main(String[] args) {
		Movie_builder.Builder builder = new Movie_builder.Builder("Inception", 2010);
		
		List<Place> locations = new ArrayList<Place>();
		locations.add(new Place("California"));
		locations.add(new Place("Japan"));
		
		builder.diretor(new Person("Christopher", "Nolan")).isNetflix(true);
		builder.locations(locations);
		System.out.println(builder.build());
		
		
	}

}
