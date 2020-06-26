package aula05_TakeAway;

public class TakeAway_Main {
	
	public static void main(String[] args) {
		Commodity[] menu = new Commodity[2];
		menu[0] = BeverageFactory.createBeverage(Temperature.COLD);
		menu[1] = MeatFactory.createMeat(Temperature.WARM);
		
		Container[] containers = new Container[2];
		containers[0] = ContainerFactory.createContainerFor(menu[0]);
		containers[1] = ContainerFactory.createContainerFor(menu[1]);
		
		containers[0].placeCommodity(menu[0]);
		containers[1].placeCommodity(menu[1]);
		
		System.out.println("Thank you for choosing your meal!");
		for(Container c : containers) {
			System.out.println(c);
		}
	}
	

}
