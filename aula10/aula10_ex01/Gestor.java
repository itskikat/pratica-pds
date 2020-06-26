package aula10_ex01;

import java.util.*;

public class Gestor implements Observer {
	
	private String name;
	private List<Produto> allProducts;
	private ObserverType type;
	
	public Gestor(String name) {
		this.name = name;
		this.allProducts = new ArrayList<>();
		this.type = ObserverType.GESTOR;
	}

	@Override
	public void update(String updateMsg) {
		System.out.println("[GESTOR] " + this.name + " : " + updateMsg);
	}
	public ObserverType type() {
		return this.type;
	}
	
	public void addProduct(Produto prod) {
		this.allProducts.add(prod);
	}
	public List<Produto> getAllProducts(){
		return this.allProducts;
	}
	
	
	public void startAuction(Produto prod) {
		prod.startAuction(2);
	}
	
	

}
