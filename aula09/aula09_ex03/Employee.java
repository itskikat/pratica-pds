package aula09_ex03;

public class Employee extends Helper{
	@Override
	public void manage(String store) {
		if (canHandleStore(store))
			System. out.println("!!!Employee solved the problem (store: " + store + ")!!!");
		else {
			System.out.println("Employee hasn't authority over "+ store);
			super.manage(store);
		}
	}
}
