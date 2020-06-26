package aula08_ex02;

import java.util.ArrayList;
import java.util.List;

public class Card {
	
	private static List<Person> pers = new ArrayList<>();
	private int number;
	private static int i = 1;
	
	public Card(Person p) { 
		pers.add(p);
		this.number = i;
		i++;
	}
}
