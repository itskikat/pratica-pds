package aula03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio2 {
	
	public static ArrayList<Familia> familias = new ArrayList<>();
	public static ArrayList<String> textoLido = new ArrayList<>();
	public static ArrayList<String> textoLidoLoadFile = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int modoOperacao = -1;
		if (args.length == 0) {
			modoOperacao = 1;
		} else if (args.length == 1) {
			try {
				  File myObj = null;
				  myObj = new File(args[0]);
			      Scanner scan = new Scanner(myObj);
			      while (scan.hasNextLine()) {
			        String data = scan.nextLine();
			        textoLido.add(data);
			      }
			      scan.close();
			} catch (FileNotFoundException e) {
			      System.err.print("Error opening file\n");
			      System.exit(1);
			}
			modoOperacao = 2;
		} else {
			System.err.print("USAGE: \n"
					+ "[executable] for interactive mode \n"
					+ "[executable commandsFile] for file mode \n");
			System.exit(1);
		}
		
		
		String command = "";
		while (modoOperacao == 1 || modoOperacao == 2) {
			if (modoOperacao == 1) {
				System.out.println("Load, Map, Add, Remove, List, Lookup, Clear, Quit");
				System.out.print("Comand: ");
				command = sc.next();
			} else {
				try {
					command = textoLido.get(0).split(" ")[0];
				} catch (IndexOutOfBoundsException e) {
					command = "quit";
				}
			}
			switch (command) {
			
			case "Load":
			case "load":
				System.out.println("\nLoad Operation...");
				load(modoOperacao);
				break;
				
			case "Map":
			case "map":
				System.out.println("\nMap Operation...");
				map();
				break;
				
			case "Add":
			case "add":
				System.out.println("\nAdd Operation...");
				add(modoOperacao);
				break;
				
			case "Remove":
			case "remove":
				System.out.println("\nRemove Operation...");
				remove(modoOperacao);
				break;
				
			case "List":
			case "list":
				System.out.println("\nList Operation...");
				// Como nao é explicito, mas pelo output do exemplo, nos organizamos alfabeticamente os nomes, mas colocamos os nomes da mesma familia todos juntos
				
				//Primeiro ordenamos cada familia
				for (Familia familia : familias) {
					familia.sortFamily();
				}
				
				// Depois ordenamos o conjutno familias
				Collections.sort(familias, new NameComparator());
				for (Familia familia : familias) {
					for (String membro: familia.getMembros()) {
						System.out.printf("%12s %2d %2d \n",membro,familia.getX1(),familia.getX2());
					}
				}
				break;
				
			case "Lookup":
			case "lookup":
				System.out.println("\nLookup Operation...");
				lookup(modoOperacao);
				break;
				
			case "Clear":
			case "clear":
				System.out.println("\nClear Operation...");
				familias.clear();
				break;
				
			case "Quit":
			case "quit":
				System.out.println("\nPrograma a terminar...");
				System.exit(0);
			
			}
			if (modoOperacao == 2) {
				textoLido.remove(0);
			}
			
		}
		
		sc.close();

	}

	public static void load(int modoOperacao) {
		if (modoOperacao == 1) {
			System.out.println("Ficheiro para ler: ");
			String filename = "";
			if (sc.hasNext()) {
				filename = sc.next();
			}
			try {
	            File f = new File(filename);
	            Scanner fileScan = new Scanner(f);
	            while (fileScan.hasNextLine()) {
	            	String line = fileScan.nextLine();
	            	textoLidoLoadFile.add(line);
	            }
	            fileScan.close();
			} catch (FileNotFoundException e) {
	            System.err.print("Erro ao abrir ficheiro.");
	            System.exit(1);
	        }      
		} else if (modoOperacao == 2) {
			String filename = textoLido.get(0).split(" ")[1];
			try {
	            File f = new File(filename);
	            Scanner fileScan = new Scanner(f);
	            while (fileScan.hasNextLine()) {
	            	String line = fileScan.nextLine();
	            	textoLidoLoadFile.add(line);
	            }
	            fileScan.close();
			} catch (FileNotFoundException e) {
	            System.err.print("Erro ao abrir ficheiro.");
	            System.exit(1);
	        }    
		}
		
		for (String line: textoLidoLoadFile) {
			if (line.charAt(0) == ('>')) {
            	continue;
            } else {
            	String[] memberInfo = line.split(" ");
            	String[] ports = memberInfo[0].split("-");
            	boolean adicionado = false;
            	int x1 = Integer.parseInt(ports[0]);
            	int x2 = Integer.parseInt(ports[1]);
            	for (Familia familia : familias) {
            		if (familia.getMembros().contains(memberInfo[1])) {
            			System.err.println("\nMembro já existente");
            			adicionado = true;
            			break;
            		}
            		if (familia.getX1() == x1 && familia.getX2() == x2) {
            			//Esta divisao em 2 if's evita repetiçao da adiçao de membros quando efetuadas 2 operaçoes de Load seguidas do mesmo ficheiro
            			if (checkName(memberInfo[1])) {
            				familia.addMembro(memberInfo[1]);
            				adicionado = true;
            				break;
            			} else {       				
            				adicionado = true;
            				break;
            			}
            		}
            	}
            	if (adicionado == false) {
            		Familia f1 = new Familia(x1, x2);
            		if (checkName(memberInfo[1])) {
            			f1.addMembro(memberInfo[1]);
                		familias.add(f1);
            		}
            	}
            }
          }
	}
	
	public static void map() {
		int numeroTotalMembrosFamilias = 0;
		for (Familia fam: familias) {
			for (String nome: fam.getMembros()) {
				numeroTotalMembrosFamilias++;
			}
		}
		int numeroLinhasTabela = numeroTotalMembrosFamilias;
		if (familias.size() == 0) {
			return;
		}
		int numeroColunasTabela = familias.get(0).getPortaMaisAlta()-familias.get(0).getPortaMaisBaixa()+1;
		String[][] tabelaResultados = new String[numeroLinhasTabela][numeroColunasTabela];
		for (int i = 0; i<numeroLinhasTabela; i++) {
			for (int c = familias.get(0).getPortaMaisBaixa();c<familias.get(0).getPortaMaisAlta()+1; c++) {
				tabelaResultados[i][c-familias.get(0).getPortaMaisBaixa()] = "  ";
			}
		}
		Collections.sort(familias, new DefaultComparator());
		//printPrimeiralinha
		System.out.printf("%6s %17s ","FAMILY","NAME");
		for (int i = familias.get(0).getPortaMaisBaixa(); i<= familias.get(0).getPortaMaisAlta(); i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		
		int membroAtual = 0;
		for (Familia fam: familias) {
			for (String nome: fam.getMembros()) {
				for (int i = fam.getX1(); i<= fam.getX2(); i++) {
					tabelaResultados[membroAtual][i-familias.get(0).getPortaMaisBaixa()] = "X";
				}
				membroAtual++;
			}
		}
		
		membroAtual = 0;
		for (Familia fam: familias) {
			for (String nome: fam.getMembros()) {
				System.out.printf("%6d %17s ",fam.getNumeroFamilia(),nome);
				for (int i = familias.get(0).getPortaMaisBaixa(); i< familias.get(0).getPortaMaisAlta()+1; i++) {
					System.out.printf("%3s",tabelaResultados[membroAtual][i-familias.get(0).getPortaMaisBaixa()]);
				}
				System.out.println();
				membroAtual++;
			}
		}
		
	}
	
	public static void add(int modoOperacao) {
		String name = "";
		int x1 = -1;
		int x2 = -1;
		boolean adicionado = false;
		if (modoOperacao == 1) {
			System.out.print("Name: ");
			name = sc.next();
			System.out.print("Localização (x1-x2): ");
			String localizacao = sc.next();
			String[] ports = localizacao.split("-");
			x1 = Integer.parseInt(ports[0]);
			x2 = Integer.parseInt(ports[1]);
		} else {
			if (textoLido.get(0).split(" ").length == 4) {
				name = textoLido.get(0).split(" ")[1];
				x1 = Integer.parseInt(textoLido.get(0).split(" ")[2]);
				x2 = Integer.parseInt(textoLido.get(0).split(" ")[3]);
			} else {
				name = textoLido.get(0).split(" ")[1];
				System.err.printf("%s not added. You should give name-x1-x2 \n",name);
				return;
			}
		}
		
		for (Familia familia : familias) {
			if (familia.getMembros().contains(name)) {
				System.err.println("\nMembro já existente");
				adicionado = true;
				break;
			}
			if (familia.getX1() == x1 && familia.getX2() == x2) {
				//Esta divisao em 2 if's evita repetiçao da adiçao de membros quando efetuadas 2 operaçoes de Load seguidas do mesmo ficheiro
				if (checkName(name)) {
					familia.addMembro(name);
					adicionado = true;
					break;
				}
			}
		}
		
		if (adicionado == false) {
			Familia f1 = new Familia(x1, x2);
			if (checkName(name)) {
				f1.addMembro(name);
    			familias.add(f1);
			}
		}
	}
	
	public static void remove(int modoOperacao) {
		String name = "";
		int x1 = -1;
		int x2 = -1;
		boolean removido = false;
		if (modoOperacao == 1) {
			System.out.print("Name: ");
			name = sc.next();
		} else {
			if (textoLido.get(0).split(" ").length == 2) {
				name = textoLido.get(0).split(" ")[1];
			} else {
				name = textoLido.get(1).split(" ")[0];
				textoLido.remove(0);
			}
		}
		for (Familia familia : familias) {
			if (familia.getMembros().contains(name)) {
				familia.getMembros().remove(name);
				if (familia.getMembros().size() == 0) {
					familias.remove(familia);
				}
				removido = true;
				break;
			}
		}
		if (removido == false) {
			System.err.println("Membro inexistente");
		}
	}
	
	
	public static void lookup(int modoOperacao) {
		String nameLookup = "";
		int x1 = -1;
		int x2 = -1;
		boolean encontrado = false;
		if (modoOperacao == 1) {
			System.out.print("Name: ");
			nameLookup = sc.next();
		} else {
			if (textoLido.get(0).split(" ").length == 2) {
				nameLookup = textoLido.get(0).split(" ")[1];
			} else {
				nameLookup = textoLido.get(1).split(" ")[0];
				textoLido.remove(0);
			}
		}
		
		for (Familia familia: familias) {
			for (String nome: familia.getMembros()) {
				if (nameLookup.equals(nome)) {
					System.out.printf("%d %d : ",familia.getX1(), familia.getX2());
					for (String name2 : familia.getMembros()) {
						System.out.print(name2+" ");
					}
					encontrado = true;
					break;
				}
			}
		}
		
		if (encontrado == false) {
			System.out.println("Membro Inexistente");
		}
	}
	
	public static boolean checkName(String name) {
		if (name.length() < 3 || name.length() > 30 ) return false;
		if (!Character.isLetter(name.charAt(0))) return false;
		if (!(name.matches("[0-9a-zA-Z@._]+"))) return false;
		if (name.charAt(name.length()-1) == '.' || name.charAt(name.length()-1) == '_' || name.charAt(name.length()-1) == '@') return false;
		return true;
	}
}
