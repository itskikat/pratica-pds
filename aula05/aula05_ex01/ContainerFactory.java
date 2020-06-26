package aula05_TakeAway;

public class ContainerFactory {
	public static Container createContainerFor(Commodity c) {
		if (c.getState() == State.Liquid) {
			if(c.getTemperature() == Temperature.WARM) {
				return new TermicBottle();
			}
			else {
				return new PlasticBottle();
			}
		}
		else {
			if(c.getTemperature() == Temperature.WARM) {
				return new Tupperware();
			}
			else {
				return new PlasticBag();
			}
		}
	}
}
