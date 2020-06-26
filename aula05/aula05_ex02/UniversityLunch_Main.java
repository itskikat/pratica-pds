package aula05_UniversityLunch;

public class UniversityLunch_Main {
	public static void main(String[] args) {
		LunchBuilder lunch = new CastroLunchBuilder();
		LunchDirector mealDirector = new LunchDirector(lunch);
		mealDirector.constructMeal();
		Lunch meal = mealDirector.getMeal();
		System.out.println("Ana's meal is: " + meal);
		
		mealDirector = new LunchDirector(new SnackLunchBuilder());
		mealDirector.constructMeal();
		meal = mealDirector.getMeal();
		System.out.println("Rui's meal is: " + meal);
		
		mealDirector = new LunchDirector(new CentralCantineLunchBuilder());
		mealDirector.constructMeal();
		meal = mealDirector.getMeal();
		System.out.println("My meal is: " + meal);
	}
	
}
