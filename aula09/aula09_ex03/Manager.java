package aula09_ex03;

public class Manager extends Helper{
	
	@Override
	public void manage(String store) {
		if (canHandleStore(store)) {
			System. out.println("!!!Manager solved the problem (store: " + store + " )!!!");
		}
		else {
			System.out.println("Manager hasn't authority over "+ store);
			super.manage(store);
		}
	}
}
