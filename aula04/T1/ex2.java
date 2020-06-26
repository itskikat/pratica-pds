package aula03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Familia> familias = new ArrayList<>();
		String nome;
		if (args.length == 0) {
			Scanner sc = new Scanner(System.in);
			int option = 0;
			do {
				System.out.println("1 - Load");
				System.out.println("2 - Map");
				System.out.println("3 - Add");
				System.out.println("4 - Remove");
				System.out.println("5 - List");
				System.out.println("6 - Lookup");
				System.out.println("7 - Clear");
				System.out.println("8 - Quit");
				System.out.print("Command: ");
				option = Integer.parseInt(sc.nextLine());
			
			
				switch(option) {
				case 1:
					System.out.print("filename: ");
					if (!load(sc.nextLine(), familias)) {
						System.out.println("Error reading file");
						System.exit(0);
					}
					break;
				case 2:
					if (!map(familias)) {
						System.out.println("Error mapping street");
					}
					break;
				case 3:
					System.out.print("Nome: ");
					nome = sc.nextLine();
					System.out.print("x1: ");
					int x1 = Integer.parseInt(sc.nextLine());
					System.out.print("x2: ");
					int x2 = Integer.parseInt(sc.nextLine());
					if (!add(nome, x1, x2, familias)) {
						System.out.println("Error adding member");
					}
					break;
				case 4:
					System.out.print("Nome: ");
					nome = sc.nextLine();
					if (!remove(nome, familias)) {
						System.out.println("Error removing member");
					}
					break;
				case 5:
					list(familias);
					break;
				case 6:
					System.out.print("Nome: ");
					nome = sc.nextLine();
					if (!lookUp(nome, familias)) {
						System.out.println("Error finding family");
					}
					break;
				case 7:
					familias = new ArrayList<>();
					System.out.println("cleared");	
				}
			} while (option != 8);
		} else {
			boolean quitted=false;
			Scanner sc = new Scanner(new File(args[0]));
			String option;
			do {
				option = sc.next().toLowerCase();
				System.out.println(option);
				switch(option) {
				case "load":
					if (!load(sc.next(), familias)) {
						System.out.println("Error reading file");
						break;
					}
					break;
				case "map":
					if (!map(familias)) {
						System.out.println("Error mapping street");
						break;
					}
					break;
				case "add":
					int x1, x2;
					if (sc.hasNext()) {
						nome = sc.next();
					} else {
						System.out.println("Error adding member");
						break;
					}
					if (sc.hasNextInt()) {
						x1 = sc.nextInt();
					} else {
						System.out.println("Error adding member");
						break;
					}
					if (sc.hasNextInt()) {
						x2 = sc.nextInt();
					} else {
						System.out.println("Error adding member");
						break;
					}
					if (!add(nome, x1, x2, familias)) {
						System.out.println("Error adding member");
						break;
					}
					sc.nextLine();
					break;
				case "remove":
					nome = sc.next();
					if (!remove(nome, familias)) {
						System.out.println("Error removing member");
					}
					break;
				case "list":
					list(familias);
					break;
				case "lookup":
					nome = sc.next();
					if (!lookUp(nome, familias)) {
						System.out.println("Error finding family");
						break;
					}
					break;
				case "clear":
					familias = new ArrayList<>();
					System.out.println("cleared");
					break;
				case "quit":
					quitted = true;
					break;
				}
			} while (sc.hasNextLine() && !quitted);
			sc.close();
		}
	}
	
	//load File
	public static boolean load(String fileName, ArrayList<Familia> familias) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		String linha = sc.nextLine();
		if (linha.charAt(0) == '>') { //saltar a descrição
			linha = sc.nextLine();
		}
		
		boolean added;
		while (true) {
			added = false;
			for (Familia familia : familias) {
				if (familia.getLocalizationString().equals(linha.split(" ")[0])) {
					if (familia.addMember(linha.split(" ")[1])) {
						added = true;
					} else {
						System.out.println("Erro ao adicionar membro da família");
						sc.close();
						return false;
					}
				}
			}
			
			if (!added) {
				familias.add(Familia.Familia(linha.split(" ")[0]));
				if (familias.get(familias.size()-1)==null) {
					System.out.println("Erro ao adicionar número da porta");
					sc.close();
					return false;
				}
				if (!familias.get(familias.size()-1).addMember(linha.split(" ")[1])) {
					System.out.println("Erro ao adicionar membro da família");
					sc.close();
					return false;
				}
			}
			
			if (sc.hasNextLine()) {
				linha = sc.nextLine();
			} else {
				break;
			}
		}
		sc.close();
		return true;
	}
	
	public static boolean map (ArrayList<Familia> familias) {
		if (familias.size()==0) {
			System.out.println("Empty");
			return true;
		}
		Collections.sort(familias);
		//encontrar o comprimento maximo de um nome e a range de números de porta
		int compMax = Integer.MIN_VALUE;
		int nMax = Integer.MIN_VALUE;
		int nMin = Integer.MAX_VALUE;
		for (Familia f : familias) {
			for (String membro : f.getMembros()) {
				if (membro.length()>compMax) {
					compMax = membro.length();
				}
			}
			if (f.getLocalization()[0]<nMin) {
				nMin = f.getLocalization()[0];
			}
			if (f.getLocalization()[1]>nMax) {
				nMax = f.getLocalization()[1];
			}
		}
		String format = "%6s %" + compMax + "s";
		String toPrint = String.format(format, "FAMILY", "NAME");
		
		for (int i = nMin; i<=nMax; i++) {
			toPrint+=" "+i;
		}
		System.out.println(toPrint);
		toPrint = "";
		
		int ID = 1;
		for (Familia f: familias) {
			for (String membro : f.getMembros()) {
				System.out.printf(format, String.valueOf(ID), membro);
				for (int i = nMin; i<=nMax; i++) {
					toPrint+=" ";
					if (i>=f.getLocalization()[0]&&i<=f.getLocalization()[1]) {
						toPrint+="X";
					} else {
						toPrint+=" ";
					}
				}
				System.out.println(toPrint);
				toPrint = "";
			}
			ID++;
		}
		return true;
	}
	
	public static boolean add(String nome, int x1, int x2, ArrayList<Familia> familias) {
		boolean added = false;
		for (Familia familia : familias) {
			if (familia.getLocalization()[0]==x1 && familia.getLocalization()[1]==x2) {
				if (familia.addMember(nome)) {
					added = true;
				} else {
					System.out.println("Erro ao adicionar membro da família");
					return false;
				}
			}
		}
		
		if (!added) {
			familias.add(Familia.Familia(x1+"-"+x2));
			if (familias.get(familias.size()-1)==null) {
				System.out.println("Erro ao adicionar número da porta");
				return false;
			}
			if (!familias.get(familias.size()-1).addMember(nome)) {
				System.out.println("Erro ao adicionar membro da família");
				return false;
			}
		}
		return true;
	}
	
	public static boolean remove(String nome, ArrayList<Familia> familias) {
		int i=0;
		for (Familia familia : familias) {
			if (familia.remove(nome)) {
				if (familia.getMembros().size() == 0) {
					familias.remove(i);
				}
				return true;
			} else {
				i++;
			}
		}
		System.out.println("Utilizador não encontrado");
		return false;
		
	}
	
	public static void list(ArrayList<Familia> familias) {
		if (familias.size()==0) {
			System.out.println("Empty");
		}
		
		ArrayList<String> list = new ArrayList<>();
		for (Familia f : familias) {
			for (String membro : f.getMembros()) {
				list.add(membro + " " + f.getLocalization()[0] + " " + f.getLocalization()[1]);
			}
		}
		Collections.sort(list);
		for (String entry : list) {
			System.out.println(entry);
		}
	}
	
	public static boolean lookUp(String nome, ArrayList<Familia> familias) {
		for (Familia f : familias) {
			for (String membro : f.getMembros()) {
				if (membro.equals(nome)) {
					System.out.print(f.getLocalization()[0] + " " + f.getLocalization()[1] + " :");
					for (String membro2 : f.getMembros()) {
						System.out.print(" " + membro2);
					}
					System.out.println();
					return true;
				}
			}
		}
		return false;
	}

}
