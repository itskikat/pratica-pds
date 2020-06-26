package aula10_ex01;

import java.util.*;

public class LeiLao_Main {
	
	public static void main(String[] args) {
		
		Produto p1 = new Produto("Produto1", 1.0);
		Produto p2 = new Produto("Produto2", 2.0);
		Produto p3 = new Produto("Produto3", 3.0);
		Produto p4 = new Produto("Produto4", 4.0);
		Produto p5 = new Produto("Produto5", 5.0);
		
		Cliente c1 = new Cliente("Cliente1");
		Cliente c2 = new Cliente("Cliente2");
		Cliente c3 = new Cliente("Cliente3");
		
		Gestor g1 = new Gestor("Gestor1");

		// Atribuir Gestor a cada produto
		p1.attach(g1);
		p2.attach(g1);
		p3.attach(g1);
		p4.attach(g1);
		p5.attach(g1);

		// Clientes Interessados nos produtos
		p1.attach(c1);
		p1.attach(c3);
		p2.attach(c2);
		p3.attach(c1);
		p3.attach(c2);
		p3.attach(c3);
		p4.attach(c1);
		p5.attach(c2);
		p5.attach(c3);
		
		g1.startAuction(p3);
		g1.startAuction(p5);
		g1.addProduct(p1);
		g1.addProduct(p2);
		g1.addProduct(p3);
		g1.addProduct(p4);
		g1.addProduct(p5);
		
		List<Produto> listaLeilao = c1.getAuctionList(g1);
		System.out.println("\nLista de Produtos em Leilao: ");
		for(Produto p: listaLeilao)
			System.out.println(p);
		
		List<Produto> listaProdutos = g1.getAllProducts();
		System.out.println("\nLista de Produtos: ");
		for(Produto p: listaProdutos)
			System.out.println(p);
		
		System.out.println();
		c1.placeBid(p1, 2.4);
		System.out.println();
		c1.placeBid(p3, 15.0);
		
		

	}

}
