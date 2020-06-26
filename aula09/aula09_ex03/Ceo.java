package aula09_ex03;

public class Ceo extends Helper{

	@Override
	public void manage(String store) {
		if (canHandleStore(store))
			System. out.println("!!!CEO solved the problem (store: " + store + ")!!!");
		else {
			System.out.println("CEO hasn't authority over "+ store);
			System.out.println("No one could solve the problem");
		}
			
	}
}
