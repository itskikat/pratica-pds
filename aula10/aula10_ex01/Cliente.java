package aula10_ex01;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Observer {

	private String name;
	private List<Produto> auctionProducts;
	private ObserverType type;
	
	public Cliente(String name) {
		this.name = name;
		this.auctionProducts = new ArrayList<>();
		this.type = ObserverType.GESTOR;
	}
	
	@Override
	public void update(String updateMsg) {
		System.out.println("[CLIENTE] " + this.name + " : " + updateMsg);
	}
	@Override
	public ObserverType type() {
		return this.type;
	}
	
	public boolean placeBid(Produto prod, double bid) {
		return prod.makeBid(this, bid);
	}
	
	public List<Produto> getAuctionList(Gestor gestor){
		List<Produto> temp = gestor.getAllProducts();
		for(Produto p: temp) {
			if (p.getState() == Estados.LEILAO) {
				this.auctionProducts.add(p);
			}
		}
		return this.auctionProducts;
	}

}
