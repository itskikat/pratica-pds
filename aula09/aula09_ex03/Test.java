package aula09_ex03;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Employee e = new Employee();
		Supervisor s = new Supervisor();
		Manager m = new Manager();
		Ceo c = new Ceo();
		
		ArrayList<String> storeEmp = new ArrayList<>();
		storeEmp.add("Cont Bom Dia");
		e.setStores(storeEmp);
		
		ArrayList<String> storeSup = new ArrayList<>();
		storeSup.add("Cont Bom Dia");
		storeSup.add("Cont Meu Super");
		s.setStores(storeSup);
		
		ArrayList<String> storeMan = new ArrayList<>();
		storeMan.add("Cont Bom Dia");
		storeMan.add("Cont Meu Super");
		storeMan.add("Cont Aveiro");
		m.setStores(storeMan);
		
		ArrayList<String> storeCeo = new ArrayList<>();
		storeCeo.add("Cont Bom Dia");
		storeCeo.add("Cont Meu Super");
		storeCeo.add("Cont Aveiro");
		storeCeo.add("Cont Portugal");
		c.setStores(storeCeo);
		
		Helper problemHelper =
				e.setSuccessor(
						s.setSuccessor(
								m.setSuccessor(c)
						)
				);
		
		problemHelper.manage("Cont Bom Dia");
		System.out.println("-------------------------------");
		problemHelper.manage("Cont Meu Super");
		System.out.println("-------------------------------");
		problemHelper.manage("Cont Aveiro");
		System.out.println("-------------------------------");
		problemHelper.manage("Cont Portugal");
		System.out.println("-------------------------------");
		problemHelper.manage("SONAE");
		
	}
}
