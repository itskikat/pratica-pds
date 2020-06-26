package guiao01;

import java.io.*;
import java.util.*;

public class ex01 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File puzzleFile = new File("teste-solver.txt");
		Scanner sc = new Scanner(puzzleFile);
		int size = sc.nextLine().length();
		
		if (size > 50) {
			System.out.println("ERROR! Puzzle too big!");
			System.exit(1);
		}
		
		List<String> wordsToSearch = wordsToSearch(puzzleFile, size);
		//System.out.println(wordsToSearch);
		
		boolean duplicates = findDuplicates(wordsToSearch);
		if(duplicates==true) {
			System.out.println("ERROR! Duplicates were found!");
			System.exit(1);
		}
		
		Character[][] actualPuzzle = getPuzzle(puzzleFile, size);	
		
		for(String word: wordsToSearch) {
			word = word.toUpperCase();
			String[] vals = findWord(actualPuzzle, word);
			System.out.printf("%-15s %-6d %-6s %s\n", word, word.length(), vals[0], vals[1]);
		}
		
		sc.close();
	}
	
	public static ArrayList<String> wordsToSearch(File thepuzzle, int size) throws FileNotFoundException{
		ArrayList<String> wordsToSearch = new ArrayList<String>();
		Scanner puzzle = new Scanner(thepuzzle);
		
		for(int k=0; k<size; k++) {
			puzzle.nextLine();
		}
		
		while(puzzle.hasNextLine()) {
			String linha = puzzle.nextLine();
			
			String[] words = linha.split("[,; ]");     // Palavras podem estar separadas por , ; ou espaco
			for(int k=0; k<words.length; k++) {
				if(words[k].length() < 3) {            // Tamanho minimo == 4
					System.out.printf("Ignoring word %s . It doesnt have 4 chars.\n\n", words[k]);
					continue;
				}
				
				for (int i=0; i<words[k].length(); i++) {
					if(!Character.isAlphabetic(words[k].charAt(i))) {
						System.out.printf("Ignoring word %s. It contains non alphabetic chars\n\n", words[k]);
						break;
					}
				}
				wordsToSearch.add(words[k]);
			}
		}
		
		puzzle.close();
		return wordsToSearch;
	}
	
	// Search for duplicates in the words to Jumble
	public static boolean findDuplicates(List<String> wordsToSearch) {
		boolean flag = false;
		
		for (int k=0; k<wordsToSearch.size(); k++) {
			for(int j=k+1; j<wordsToSearch.size(); j++) {
				if (wordsToSearch.get(k).contains(wordsToSearch.get(j)) || 
						wordsToSearch.get(j).contains(wordsToSearch.get(k))) { 
					return flag = true;
				}
			}
		}
		return flag;
	}
	
	public static Character[][] getPuzzle(File puzzleFile, int size) throws FileNotFoundException{
		Scanner puzzle = new Scanner(puzzleFile);
		Character[][] actualPuzzle = new Character[size][size];
		
		for(int i=0; i<size; i++) {
			String linha = puzzle.nextLine();
			for(int k=0; k<size; k++) {
				actualPuzzle[i][k] = linha.charAt(k);
			}
		}
		
		puzzle.close();
		return actualPuzzle;
	}
	
	
	public static String[] findWord(Character[][] actualPuzzle, String searching) {
		boolean found = false;
		char firstChar = searching.charAt(0);
		int size = actualPuzzle.length;
		
		//String[] vals = new String[2];
		for(int r=0; r<size; r++) {
			for(int c=0; c<actualPuzzle[r].length; c++) {
				if(actualPuzzle[r][c] == firstChar) {
					// CHECK IF WORD IS ON THE PUZZLE, BOTH DIRECTIONS!
					
					// HORIZONTAL WORD
					if(checkDirections(actualPuzzle, searching, r, c, 0, 1)) {
						found = true;
						return new String[] {(r+1) + "," + (c+1), "RIGHT"};
					}
					if(checkDirections(actualPuzzle, searching, r, c, 0, -1)) {
						found = true;
						return new String[] {(r+1) + "," + (c+1), "LEFT"};
					}
					
					// VERTICAL WORD
					if(checkDirections(actualPuzzle, searching, r, c, 1, 0)) {
						found = true;
						return new String[] {(r+1) + "," + (c+1), "DOWN"};
					}
					if(checkDirections(actualPuzzle, searching, r, c, -1, 0)) {
						found = true;
						return new String[] {(r+1) + "," + (c+1), "UP"};
					}
					
					// DIAGONALS
					if(checkDirections(actualPuzzle, searching, r, c, 1, 1)) {
						found = true;
						return new String[] {(r+1) + "," + (c+1), "DOWN-RIGHT"};
					}
					if(checkDirections(actualPuzzle, searching, r, c, 1, -1)) {
						found = true;
						return new String[] {(r+1) + "," + (c+1), "DOWN-LEFT"};
					}
					if(checkDirections(actualPuzzle, searching, r, c, -1, 1)) {
						found = true;
						return new String[] {(r+1) + "," + (c+1), "UP-RIGHT"};
					}
					if(checkDirections(actualPuzzle, searching, r, c, -1, -1)) {
						found = true;
						return new String[] {(r+1) + "," + (c+1), "UP-LEFT"};
					}
				}
			}
		}
		System.out.printf("\nERROR! Word %s not found!\n", searching);
		System.exit(1);
		return null;
	}
	
	
	public static boolean checkDirections(Character[][] actualPuzzle, String searching, int row, int column, int rowInc, int colInc) {
		boolean flag = true;
		int searchRow = row;
		int searchColumn = column;
		
		for(int i=0; i<searching.length(); i++) {
			if(searchRow < 0 || searchColumn < 0 || 
					searchRow >= actualPuzzle.length || 
					searchColumn>=actualPuzzle[searchRow].length || 
					actualPuzzle[searchRow][searchColumn] != searching.charAt(i)) {
				flag = false;
				continue;
			} 
			searchColumn += colInc;
			searchRow += rowInc;
		}
		
		return flag;
	}
	


}
