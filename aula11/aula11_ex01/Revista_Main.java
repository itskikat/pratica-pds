package aula11_ex01;

import java.util.*;

public class Revista_Main {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Telemovel t1 = new Telemovel("Samsung S20", "Octa Core", 845.9, 128, 64);
		Telemovel t2 = new Telemovel("iPhone 11 Pro", "Hexa Core", 1059, 64, 12);
		Telemovel t3 = new Telemovel("Huawei P40", "Octa Core", 999, 128, 50);
		Telemovel t4 = new Telemovel("LG V50", "Octa Core", 929.32, 128, 16);
		
		Strategy myStrat = new Ascendente();
		
		List<Telemovel> telemoveis = new ArrayList<>();
		Revista revista = new Revista(myStrat, telemoveis);
		telemoveis.add(t1);
		telemoveis.add(t2);
		telemoveis.add(t3);
		telemoveis.add(t4);
		
		System.out.println("--ORDEM: Ascendente, Descendente");
		System.out.println("--ORDEM: ");
		String ordem = sc.next();
		if (ordem.toUpperCase().equals("DESCENDENTE"))
			revista.setStrategy(new Descendente());
		
		System.out.println("--ORDENAR POR: Nome, Processador, Preco, Memoria, Camara");
		System.out.println("--ORDENAR POR: ");
		String atributo = sc.next();
		telemoveis = revista.ordenacao(atributo);
		for (Telemovel tel: telemoveis)
			System.out.println(tel);
		
		
		
		
	}
	
}
