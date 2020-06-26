package aula05_UniversityLunch;

public class Lunch {
	private String drink;
	private String mainCourse;
	private String side;
	
	protected void setDrink(String drink) {
		this.drink = drink;
	}
	
	protected void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}
	
	protected void setSide(String side) {
		this.side = side;
	}
	
	@Override
	public String toString() {
		return String.format("[ drink + %s, main course: %s, side: %s ]", this.drink, this.mainCourse, this.side);
	}

}
