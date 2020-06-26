package aula05_TakeAway;

public class MeatFactory {
	public static Commodity createMeat(Temperature temperature) {
		if(temperature == Temperature.COLD) {
			return new Tuna();
		}
		else {
			return new Pork();
		}
	}

}
