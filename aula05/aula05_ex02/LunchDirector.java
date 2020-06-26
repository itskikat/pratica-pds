package aula05_UniversityLunch;

public class LunchDirector {
	private LunchBuilder lunchBuilder;
	
	public LunchDirector(LunchBuilder lb) {
		this.lunchBuilder = lb;
	}
	
	public Lunch getMeal() {
		return lunchBuilder.getMeal();
	}
	
	public void constructMeal() {
		lunchBuilder.buildDrink();
		lunchBuilder.buildMainCourse();
		lunchBuilder.buildSide();
	}

}
