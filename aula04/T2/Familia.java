package aula03;

import java.util.ArrayList;

public class Familia {
	
	private int x1;
	private int x2;
	private int intervalo;
	private int numeroFamilia;
	private ArrayList<String> membros;
	private static int id = 1;
	private static int portaMaisBaixa = 10000000;
	private static int portaMaisAlta = 0;
	
	
	public Familia(int x1, int x2) {
		if (0 < x1 && x1 <= x2) {
			this.x1 = x1;
			this.x2 = x2;
			this.intervalo = x2-x1+1;
			this.membros = new ArrayList<>();
			this.numeroFamilia = id;
			id++;
			if (x1<portaMaisBaixa) {
				portaMaisBaixa = x1;
			}
			if (x2>portaMaisAlta) {
				portaMaisAlta = x2;
			}
		} else {
			System.err.print("x1<x2");
			System.exit(1);
		}
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getIntervalo() {
		return intervalo;
	}
	
	public int getNumeroFamilia() {
		return numeroFamilia;
	}
	
	public int getPortaMaisAlta() {
		return portaMaisAlta;
	}
	
	public int getPortaMaisBaixa() {
		return portaMaisBaixa;
	}

	public ArrayList<String> getMembros() {
		return membros;
	}
	
	public void addMembro(String name) {
		this.membros.add(name);
	}	
	
	public void sortFamily() {
		String temp;
        for (int i = 0; i < this.membros.size(); i++) {
            for (int j = i + 1; j < this.membros.size(); j++) { 
                if (this.membros.get(i).compareTo(this.membros.get(j))>0) {
                    temp = this.membros.get(i);
                    this.membros.remove(i);
                    this.membros.add(i, this.membros.get(j-1));
                    this.membros.remove(j);
                    this.membros.add(j, temp);
                }
            }
        }
        return;
	}
}
