package aula05_Movie;

public class Person {
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "PERSON [firstName: " + firstName + ", lastName: " + lastName + "]";
		return out;
	}
}
