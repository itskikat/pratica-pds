package aula05_TakeAway;

public class BeverageFactory {
	public static Commodity createBeverage(Temperature temperature) {
		if(temperature == Temperature.COLD) {
			return new FruitJuice();
		}
		else {
			return new Milk();
		}
	}
}
