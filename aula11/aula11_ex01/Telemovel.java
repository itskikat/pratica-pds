package aula11_ex01;

import java.util.*;

public class Telemovel {
	
	private String processador;
	private double preco;
	private int memoria;
	private double camara;
	private String nome;
	
	public Telemovel(String nome, String processador, double preco, int memoria, double camara) {
		this.nome = nome;
		this.processador = processador;
		this.preco = preco;
		this.memoria = memoria;
		this.camara = camara;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public double getCamara() {
		return camara;
	}

	public void setCamara(double camara) {
		this.camara = camara;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// Comparators 
	public static Comparator<Telemovel> compareProcessador = new Comparator<Telemovel>() {
		public int compare(Telemovel t1, Telemovel t2) {
			return t1.getProcessador().compareTo(t2.getProcessador());
		}
	};
	
	public static Comparator<Telemovel> comparePreco = new Comparator<Telemovel>() {
		public int compare(Telemovel t1, Telemovel t2) {
			if (t1.getPreco() > t2.getPreco())
				return 1;
			else if (t1.getPreco() < t2.getPreco())
				return -1;
			else
				return 0;
		}
	};
	
	public static Comparator<Telemovel> compareMemoria = new Comparator<Telemovel>() {
		public int compare(Telemovel t1, Telemovel t2) {
			if (t1.getMemoria() > t2.getMemoria())
				return 1;
			else if (t1.getMemoria() < t2.getMemoria())
				return -1;
			else
				return 0;
		}
	};
	
	public static Comparator<Telemovel> compareCamara = new Comparator<Telemovel>() {
		public int compare(Telemovel t1, Telemovel t2) {
			if (t1.getCamara() > t2.getCamara())
				return 1;
			else if (t1.getCamara() < t2.getCamara())
				return -1;
			else
				return 0;
		}
	};
	
	public static Comparator<Telemovel> compareNome = new Comparator<Telemovel>() {
		public int compare(Telemovel t1, Telemovel t2) {
			return t1.getNome().compareTo(t2.getNome());
		}
	};
	
	
	@Override
	public String toString() {
		return "[TELEMOVEL] " + this.nome + ", Processador: " + this.processador + ", Memoria: " + this.memoria +
				", Camara: " + this.camara + ", Preco: " + this.preco;
	}

}


