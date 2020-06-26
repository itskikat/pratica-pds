package aula09_ex03;

import java.util.ArrayList;

public abstract class Helper {
	private Helper successor = null;
	private ArrayList<String> stores;
	
	public void setStores(ArrayList<String> stores) {
		this.stores=stores;
	}
		
	public void manage(String store) {
		if(successor != null)
			successor.manage(store);
		else
			System.out.println("No more Helpers for store " + store + ", your problem can't be resolved");
	}
	public boolean canHandleStore(String store) {
		if(stores.contains(store)) {
			return true;
		}
		return false;
	}
	
	public Helper setSuccessor(Helper successor) {
		this.successor = successor;
		return this;
	}
}
