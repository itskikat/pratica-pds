package P01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		int argLen = args.length;
		if (argLen < 4 || (argLen % 2) != 0) {
			System.out.println("S�o necess�rios par�metros de entrada adicionais.");
			System.exit(1);
		}
		int count = 0, dim = 0;
		String fileInput = null, fileOutput = null;
		boolean o = false;
		while (count < argLen) {
			String arg = args[count];
			switch (arg) {
				case "-i":
					fileInput = args[count+1];
					count+=2;
					break;
				case "-s":
					dim = Integer.parseInt(args[count+1]);
					count+=2;
					break;
				case "-o":
					o = true;
					fileOutput = args[count+1];
					count+=2;
					break;
				default:
					System.out.println("Argumento inv�lido");
					System.exit(1);
			}
		}
		
		File f = new File(fileInput);
		Scanner sc = null;
		ArrayList<String> words = new ArrayList<String>();
		
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		
		while (sc.hasNextLine()){
			String line = sc.nextLine();
			String[] lineSplit = line.split(",|;|\\s");
			for (String p : lineSplit) {
				words.add(p);
			}
		}
		
		WSGenerator puzz = new WSGenerator(words, dim);
		puzz.generateWS();
		if (o) {
			try {
				FileWriter fOut = new FileWriter(fileOutput);
				String[][] wordSearch = puzz.getsL();
				for (int c = 0; c < dim; c++) {
					for (int l = 0; l < dim; l++) {
						fOut.write(wordSearch[c][l]);
					}
					fOut.write("\n");
				}
				fOut.close();
				
			} catch (IOException e) {
				System.out.println("File not found.");
				e.printStackTrace();
			}
			
		} else {
			puzz.printWordSearch();
		}
		/*
		ArrayList<String> aa = puzz.toArrayList();
		Puzzle bb = new Puzzle(aa, words);
		bb.findWordsDiagonal();
		bb.findWordsHorizontal();
		bb.findWordsVertical();
		bb.printResults();
		*/
	}
}
