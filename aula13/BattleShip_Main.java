package aula13;

import java.util.*;

public class BattleShip_Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		menu();
		String choice = sc.nextLine();
		String filename;
		switch(choice) {
			case "A":
				System.out.println("Please enter configurations file name (XML): ");
				filename = sc.nextLine();
				LoadConfigurations configs = new LoadConfigurations(filename);
				// TO DO
				break;
			case "B":
				// TO DO
				break;
			case "C":
				// TO DO
				break;
			case "D":
				System.out.println("Thank you for playing!");
				System.exit(1);
			default:
				System.out.println("ERROR! Option not defined! Exiting...");
				System.exit(1);
		}
		
		
	}
	
	
	public static void menu() {
		System.out.println("---- Welcome to BatleShip! ---");
		System.out.println(">> A: Start new game");
		System.out.println(">> B: Resume previous game");
		System.out.println(">> C: See leaderboards");
		System.out.println(">> D: EXIT");
		System.out.println("Currently, the board is empty.");
		System.out.print("Select your option: ");
	}
}
