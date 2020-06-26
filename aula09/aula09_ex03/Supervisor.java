package aula09_ex03;

public class Supervisor extends Helper{
	@Override
	public void manage(String store) {
		if (canHandleStore(store))
			System. out.println("!!!Supervisor solved the problem (store: " + store + " )!!!");
		else {
			System.out.println("Supervisor hasn't authority over "+ store);
			super.manage(store);
		}
	}
}
