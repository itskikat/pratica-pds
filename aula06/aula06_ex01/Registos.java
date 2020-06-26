package aula06_PST;

import java.util.*;

public class Registos {
	// Data elements
	private ArrayList<Empregado> empregados; // Stores the employees 
	
	public Registos() {
		empregados = new ArrayList<>(); 
	}
	
	public void insere(Empregado emp) { 
		if (!empregados.contains(emp)) {
			empregados.add(emp);
		}
	}
	
	public void remove(int codigo) {
		for (Empregado empregado: empregados) {
			if (empregado.codigo() == codigo) {
				empregados.remove(empregado);
			}
		}
	}
	
	public boolean isEmpregado(int codigo) {
		for (Empregado empregado: empregados) {
			if (empregado.codigo() == codigo) {
				return true;
			}
		}
		return false;
	}
	
	public List<Empregado> listaDeEmpregados() {
		return empregados;
	}

}
