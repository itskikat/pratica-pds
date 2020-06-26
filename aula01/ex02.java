package guiao01;

import java.io.*;
import java.util.*;

public class ex02 {
	
	public static void main(String[] args) throws FileNotFoundException {
		//String file = args[1];
		//Integer size = Integer.parseInt(args[2]);
		
		File wordsToRead = new File("wordlist_1.txt");       // File with words to Jumble 
		int size = 14;                                       // Grid size
		
		ArrayList<String> words = readWords(wordsToRead);
		
		// Checks for any duplicate words in the file provided
		boolean NOduplicates = findDuplicates(words);
		if(NOduplicates==true) {
			System.out.println("ERROR! Duplicates were found!");
			System.exit(1);
		}
		
		Character[][] theGrid = createGrid(size);
		Character[][] thePuzzle = createPuzzle(words, theGrid, size);
		
		// Prints the puzzle generated
		for (int r=0; r<thePuzzle.length; r++) {
			for (int c=0; c<thePuzzle[r].length; c++) {
				System.out.print(thePuzzle[r][c] + " ");
			}
			System.out.println();
		}
		
		System.out.println("----------------------------");
		System.out.println("-------WORDS IN PUZZLE------");
		System.out.println("----------------------------");
		
		// Prints where each word is in the puzzle
		for(String line: positions) {
			System.out.println(line);
		}
		
		// Saves puzzle+positions to text file
		String file = "puzzleGen.txt";
		writeToFile(file, thePuzzle);
		
		
	}
	

	public static final Random RANDOM = new Random();
	private static ArrayList<String> positions = new ArrayList<String>(); //where words are situated
	
	// Reads text-file with the words to jumble in the puzzle
	public static ArrayList<String> readWords(File wordsToRead) throws FileNotFoundException{
		ArrayList<String> wordsToJumble = new ArrayList<String>();
		Scanner sc = new Scanner(wordsToRead);
		
		while(sc.hasNextLine()) {
			String linha = sc.nextLine();
			
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
				wordsToJumble.add(words[k]);
			}
		}
		
		sc.close();
		
		// Check if there are too many words -- max Puzzle size == 50*50
		if(wordsToJumble.size()>(50*50)) {
			System.out.println("ERROR!! TOO MANY WORDS");
			System.exit(1);
		}
		return wordsToJumble;
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
	
	
	// Grid filled with random alphabetic chars
	public static Character[][] createGrid(int size){
		Character[][] grid = new Character[size][size];
		// fills grid with random upper-case characters
		for(int r=0; r<size; r++) {
			for(int c=0; c<size; c++) {
				grid[r][c] = (char)(RANDOM.nextInt(26)+'A');
			}
		}
		return grid;
	}
	
	// Makes the puzzle with the words provided
	public static Character[][] createPuzzle(ArrayList<String> wordsToJumble, Character[][] theGrid, int size){
		for(int k=0; k<wordsToJumble.size(); k++) {
			int randomDir = (int)(Math.random()*8) + 1;
			
			// DIRECTIONS -- up, down, left, right, up-left, up-right, down-left, down-right
			switch(randomDir) {
			// UP
			case(1):
				int maxRowUp = size-1;
				int minRowUp = wordsToJumble.get(k).length()-1;
				// where it will be placed
				int rowUp = (int)(Math.random()*(maxRowUp-minRowUp))+minRowUp;
				int colUp = (int)(Math.random()*(size));
				// store position on puzzle
				positions.add(wordsToJumble.get(k)+"\t"+(rowUp+1)+","+(colUp+1)+"\t UP");
				// add word to the grid
				for(int i=0; i<wordsToJumble.get(k).length(); i++) {
					theGrid[rowUp][colUp] = wordsToJumble.get(k).toUpperCase().charAt(i);
					rowUp--;
				}
				break;
				
			// DOWN	
			case(2):
				int maxRowDown = wordsToJumble.get(k).length()-1;
				// where it will be placed
				int rowDown = (int)(Math.random()*(maxRowDown));
				int colDown = (int)(Math.random()*(size));
				// store position on puzzle
				positions.add(wordsToJumble.get(k)+"\t"+(rowDown+1)+","+(colDown+1)+"\t DOWN");
				// add word to the grid
				for(int i=0; i<wordsToJumble.get(k).length(); i++) {
					theGrid[rowDown][colDown] = wordsToJumble.get(k).toUpperCase().charAt(i);
					rowDown++;
				}
				break;
				
			// LEFT
			case(3):
				int maxColLeft = size-1;
				int minColLeft = wordsToJumble.get(k).length()-1;
				// where it will be placed
				int rowLeft = (int)(Math.random()*(size));
				int colLeft = (int)(Math.random()*(maxColLeft-minColLeft))+minColLeft;
				// store position on puzzle
				positions.add(wordsToJumble.get(k)+"\t"+(rowLeft+1)+","+(colLeft+1)+"\t LEFT");
				// add word to the grid
				for(int i=0; i<wordsToJumble.get(k).length(); i++) {
					theGrid[rowLeft][colLeft] = wordsToJumble.get(k).toUpperCase().charAt(i);
					colLeft--;
				}
				break;
				
			// RIGTH
			case(4):
				int maxColRigth = size-wordsToJumble.get(k).length();
				// where it will be placed
				int rowRigth = (int)(Math.random()*(size));
				int colRight = (int)(Math.random()*(maxColRigth));
				// store position on puzzle
				positions.add(wordsToJumble.get(k)+"\t"+(rowRigth+1)+","+(colRight+1)+"\t RIGHT");
				// add word to the grid
				for(int i=0; i<wordsToJumble.get(k).length(); i++) {
					theGrid[rowRigth][colRight] = wordsToJumble.get(k).toUpperCase().charAt(i);
					colRight++;
				}
				break;
				
			// UP-LEFT
			case(5):
				int maxColULeft = size-wordsToJumble.get(k).length()-1;
				int minColULeft = wordsToJumble.get(k).length()-1;
				int maxRowULeft = size-wordsToJumble.get(k).length()-1;
				int minRowULeft = wordsToJumble.get(k).length()-1;
				// where it will be placed
				int rowUL = (int)(Math.random()*(maxRowULeft-minRowULeft))+minRowULeft;
				int colUL = (int)(Math.random()*(maxColULeft-minColULeft))+minColULeft;
				// store position on puzzle
				positions.add(wordsToJumble.get(k)+"\t"+(rowUL+1)+","+(colUL+1)+"\t UP-LEFT");
				// add word to the grid
				for(int i=0; i<wordsToJumble.get(k).length(); i++) {
					theGrid[rowUL][colUL] = wordsToJumble.get(k).toUpperCase().charAt(i);
					rowUL--;
					colUL--;
				}
				break;
				
			// UP-RIGHT
			case(6):
				int maxColURight = size-wordsToJumble.get(k).length();
				int minColURight = 0;
				int maxRowURight = size;
				int minRowURight = wordsToJumble.get(k).length()-1;
				// where it will be placed
				int rowUR = (int)(Math.random()*(maxRowURight-minRowURight))+minRowURight;
				int colUR = (int)(Math.random()*(maxColURight-minColURight))+minColURight;
				// store position on puzzle
				positions.add(wordsToJumble.get(k)+"\t"+(rowUR+1)+","+(colUR+1)+"\t UP-RIGHT");
				// add word to the grid
				for(int i=0; i<wordsToJumble.get(k).length(); i++) {
					theGrid[rowUR][colUR] = wordsToJumble.get(k).toUpperCase().charAt(i);
					rowUR--;
					colUR++;
				}
				break;
				
			// DOWN-LEFT
			case(7):
				int maxColDLeft = size;
				int minColDLeft = wordsToJumble.get(k).length()-1;
				int maxRowDLeft = size-wordsToJumble.get(k).length();
				int minRowDLeft = 0;
				// where it will be placed
				int rowDL = (int)(Math.random()*(maxRowDLeft-minRowDLeft))+minRowDLeft;
				int colDL = (int)(Math.random()*(maxColDLeft-minColDLeft))+minColDLeft;
				// store position on puzzle
				positions.add(wordsToJumble.get(k)+"\t"+(rowDL+1)+","+(colDL+1)+"\t DOWN-LEFT");
				// add word to the grid
				for(int i=0; i<wordsToJumble.get(k).length(); i++) {
					theGrid[rowDL][colDL] = wordsToJumble.get(k).toUpperCase().charAt(i);
					rowDL++;
					colDL--;
				}
				break;
				
			// DOWN-RIGHT
			case(8):
				int maxColDRight = size-wordsToJumble.get(k).length();
				int minColDRight = 0;
				int maxRowDRight = size-wordsToJumble.get(k).length();
				int minRowDRight = 0;
				// where it will be placed
				int rowDR = (int)(Math.random()*(maxRowDRight-minRowDRight))+minRowDRight;
				int colDR = (int)(Math.random()*(maxColDRight-minColDRight))+minColDRight;
				// store position on puzzle
				positions.add(wordsToJumble.get(k)+"\t"+(rowDR+1)+","+(colDR+1)+"\t DOWN-RIGHT");
				// add word to the grid
				for(int i=0; i<wordsToJumble.get(k).length(); i++) {
					theGrid[rowDR][colDR] = wordsToJumble.get(k).toUpperCase().charAt(i);
					rowDR++;
					colDR++;
				}
				break;
			
			}
		}
		return theGrid;
	}
	
	// Saves puzzle+positions to text file
	public static void writeToFile(String fileName, Character[][] thePuzzle) throws FileNotFoundException {
		PrintWriter pr = new PrintWriter(fileName);
		for(String position: positions) {
			pr.println(position);
		}
		pr.println("-------------------------");
		for (int r=0; r<thePuzzle.length; r++) {
			for (int c=0; c<thePuzzle[r].length; c++) {
				pr.print(thePuzzle[r][c] + " ");
			}
			pr.println();
		}
		
		pr.close();
		System.out.println("\nPuzzle written to file!");
		
	}
	
	
}
