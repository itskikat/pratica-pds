package aula08_ex02;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	
	private static List<Person> pers = new ArrayList<>();
	
	public static void allow(Person p) { 
		pers.add(p);
		System.out.println(p.getName() + " has parking access!");
	}

}
