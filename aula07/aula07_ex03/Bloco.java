package lab0703;

import java.util.ArrayList;
import java.util.List;

public class Bloco implements Figure{
	private String name;
	private List<Figure> associates = new ArrayList<>();
	
	public Bloco (String name) {
		this.name=name;
	}
	
	public void add(Figure fig) {
		associates.add(fig);
	}

	public void draw() {
		System.out.println(this.toString());
		for(Figure fig : associates) {
			if(fig instanceof Bloco) {
				System.out.print("\t");
				((Bloco)fig).draw();
			}
			else {
				System.out.println("\t" + fig.toString());
			}
		}
	}
	public String toString() {
		return "Window " + name;
	}
	
	
	
}
