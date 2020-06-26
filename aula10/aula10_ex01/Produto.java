package aula10_ex01;

import java.util.*;

public class Produto {
	
	private int code;
	private String description;
	private double baseval;
	private Estados state;
	private double bestBid;
	private int timestamp;
	private static int count = 0;
	
	private List<Observer> observers;
	
	public Produto(String description, double baseval) {
		count++;
		this.code = count;
		this.description = description;
		this.baseval = baseval;
		this.bestBid = baseval;
		this.state = Estados.STOCK;
		this.observers = new ArrayList<>();
		
	}
	
	public void startAuction(int timestamp) {
		this.state = Estados.LEILAO;
		this.timestamp = timestamp;
	}
	
	public boolean makeBid(Observer o, double bid) {
		if(this.state != Estados.LEILAO) {
			System.out.println("[PRODUTO] Id: " + this.code + " ainda nao pode ser licitado!");
			return false;
		}
		else {
			if (bid > this.bestBid) {
				this.observers.add(o);
				this.bestBid = bid;
				String updateMsg = "[PRODUTO] ID: " + this.code + " recebeu uma licitacao: " + bid;
				this.notifyObservers(updateMsg);
				return true;
			}
			for (Observer obs: this.observers) {
				if(obs.type() == ObserverType.GESTOR) {
					String updateMsg = "Produto ID: " + this.code + " recebeu uma licitacao: " + bid;
					obs.update(updateMsg);
				}		
			return false;
			}
		}
		return false;
	}

	public void setState(Estados estado) {
		this.state = estado;
	}
	public Estados getState() {
		return this.state;
	}
	
	// adapted for TP slides
	public void attach(Observer o) {
		if (!(this.observers.contains(o)))
			this.observers.add(o);
	}
	public void notifyObservers(String updateMsg) {
		for (Observer o: this.observers)
			o.update(updateMsg);
	}
	
	@Override
	public String toString() {
		return "[PRODUTO] ID: " + this.code + ", Descricao: " + this.description + ", Estado: " + this.state + ", Valor Base: " + this.baseval;
	}
	

}
