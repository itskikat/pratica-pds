package aula11_ex03;

import java.util.*;

public class Biblioteca_Main {
	
	public static void main(String[] args) {
		
		Livro[] livros = new Livro[] {
				new Livro("Java Anti-Stress", 1, 1990, "Omodionah"),
				new Livro("A Guerra dos Padroes", 2, 1991, "Jorge Omel"),
				new Livro("A Procura da Luz", 3, 1992, "Khumatkli")
		};
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("*** Biblioteca ***");
			for (Livro l: livros) {
				System.out.println(l);
			}
			System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
			System.out.print(">>");
			String[] input = sc.nextLine().split(",");
			int livro = Integer.parseInt(input[0]);
			int operacao = Integer.parseInt(input[1]);
			Livro escolhido = livros[livro-1];
			if (alterar(escolhido,operacao)) {
				System.exit(1);
			}
			
		}
		
	}
	
	private static boolean alterar(Livro l, int op) {
		boolean flag = false;
		switch(op) {
		case 1:
			try {
                l.registar();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
                return flag = true;
            }
            break;
        case 2:
        	try {
                l.requisitar();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
                return flag = true;
            }
            break;

        case 3:
        	try {
                l.devolver();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
                return flag = true;
            }
            break;
        case 4:
        	try {
                l.reservar();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
                return flag = true;
            }
            break;
        case 5:
        	try {
                l.cancelar();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
                return flag = true;
            }
            break;
        }
		return flag;
	}
	
}
