package aula11_ex01;

import java.util.*;

public class Revista {
	
	private Strategy orderStrategy;
	private List<Telemovel> revista;
	
	public Revista(Strategy order, List<Telemovel> revista) {
		this.orderStrategy = order;
		this.revista = revista;
	}
	
	public void setStrategy(Strategy strategy) {
		this.orderStrategy = strategy;
	}
	
	public boolean adicionarTelemovel(Telemovel t) {
		if (this.revista.contains(t))
			return false;
		else {
			this.revista.add(t);
			return true;
		}
	}
	
	public List<Telemovel> ordenacao(String atributo){
		return this.orderStrategy.sortingStrategy(this.revista, atributo);
	}

}
