package lab03;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class ex2 {

	public static void main(String[] args) throws FileNotFoundException {

//------------- função MAP não está a funcionar corretamente
//------------- commands1.txt foi alterado para testar mais coisas
		
		
		Scanner file = new Scanner(new FileReader("commands1.txt"));

		Map<int[], ArrayList<String>> map = new HashMap<>();

		while (file.hasNextLine()) {
			ArrayList<String> names;
			String s = file.nextLine();
			String[] words = s.split(" ");
			words[0].toLowerCase();

			switch (words[0]) {
//LOAD        	
			case ("load"):
				Scanner ex = new Scanner(new FileReader(words[1]));
				while (ex.hasNextLine()) {

					String p = ex.nextLine();
					String[] wor = p.split(" ");
					if (!wor[0].equals(">")) {

						int[] xx = new int[2];
						String[] str = wor[0].split("-");
						xx[0] = Integer.parseInt(str[0]);
						xx[1] = Integer.parseInt(str[1]);
						names = new ArrayList<>();

						for(Entry<int[], ArrayList<String>> entry : map.entrySet()) {
														
							if (entry.getKey()[0]==xx[0] && entry.getKey()[1]==xx[1]) {
								names = entry.getValue();						//guardo os valores já no map para names, que depois vou adicionar
								
								if (names.contains(wor[1])) { 					// dá erro caso o nome já exista
									System.err.println("Name already exists");
									break;
								}
								break;
			
							}
						}
						names.add(wor[1]);
						map.put(xx, names);
					}
				}
				ex.close();
				
				break;
				
//MAP        			
			case ("map"):
				System.out.printf("%6s %11s", "FAMILY", "NAME");
				ArrayList<Integer> numbers = getNumbers(map);
				int count = 1;
				for(int number: numbers) {
					System.out.printf("%5d", number);
				}
				
				for (Entry<int[], ArrayList<String>> entry : map.entrySet()) {
					ArrayList<String> members = entry.getValue();
					for (String member: members) {
						StringBuilder cross = new StringBuilder();
						for(int i = 1; i<18; i++) {
							if(i>=entry.getKey()[0] && i<=entry.getKey()[1])
								cross.append("  X  ");
							else
								cross.append("    ");
						}
						System.out.printf("\n %6d %11s %s", count, member, cross.toString());
					}
					count++;
				}
				System.out.println();


				break;
//ADD        			
			case ("add"):
				
				if (words.length < 3) { 										// Não adiciona a pessoa se não forem dados o x1 e x2
					System.err.println("Not enough arguments too add" + words[1]);
					break;
				}

				int[] xx = new int[2];
				xx[0] = Integer.parseInt(words[2]);
				xx[1] = Integer.parseInt(words[3]);
				names = new ArrayList<>();
				
				for(Entry<int[], ArrayList<String>> entry : map.entrySet()) {
					
					if (entry.getKey()[0]==xx[0] && entry.getKey()[1]==xx[1]) {
						names = entry.getValue();								//guardo os valores já no map para names, que depois vou adicionar
						
						if (names.contains(words[1])) { 						// dá erro caso o nome já exista
							System.err.println("ADD: Name already exists");	
							break;
						}
					}
				}
				names.add(words[1]);
				map.put(xx, names);
				break;
//REMOVE        			
			case ("remove"):
				System.out.println("remove");
				for (Entry<int[], ArrayList<String>> entry : map.entrySet()) {
					
					for (String name : entry.getValue()) {
						if (name.equals(words[1])) {
							names = new ArrayList<>();
							names = entry.getValue();
														
							names.remove(name);
							map.put(entry.getKey(), names);
							
							break;	//Quando encontra nao precisa de procurar mais
						}
					}
				}
				break;
			
// Optional
				
//LIST        			
			case ("list"):
				System.out.println("\nLIST");
				for (Entry<int[], ArrayList<String>> entry : map.entrySet())
					for (String name : entry.getValue())
						System.out.println(name + " " + entry.getKey()[0] + " " + entry.getKey()[1]);
				System.out.println("ENDLIST\n");
				break;
//LOOKUP        			
			case ("lookup"):
				for (Entry<int[], ArrayList<String>> entry : map.entrySet()) {
					for (String name : entry.getValue()) {
						if (name.equals(words[1])) {
							System.out.print(entry.getKey()[0] + " " + entry.getKey()[1] + " : ");
							for (String n : entry.getValue())
								System.out.print(n + " ");
							System.out.println();
							break;
						}
					}
				}
				System.out.println("LOOKUP: Name not found");
				break;
//CLEAR
			case ("clear"):
				map.clear();
				System.out.println("Rua is no more");
				break;
//QUIT        			
			case ("quit"):
				System.out.println("End of program");
				System.exit(0);
				break;
			}
		}
		file.close();
	}
		
	public static ArrayList<Integer> getNumbers(Map<int[], ArrayList<String>> map){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int[] portas;
		int portaMin=10000, portaMax=0;
		for (Entry<int[], ArrayList<String>> entry : map.entrySet()) {
			portas = entry.getKey();
			for (int i=0; i<portas.length; i++) {
				if(portas[0]<portaMin) {
					portaMin = portas[0];
				}
				if(portas[1]>portaMax) {
					portaMax = portas[1];
				}
			}
		}	
		for(int k=portaMin; k<(portaMax+1); k++) {
			numbers.add(k);
		}	
		return numbers;
	}
	
}
