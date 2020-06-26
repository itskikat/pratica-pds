package P01;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		String openFile = null;
		boolean timing = false;
		if (args.length == 1) {
			openFile = args[0];
		}
		if (args.length == 2) {
			timing = true;
			openFile = args[1];
		} 
		File f = new File(openFile);
		long startT = System.currentTimeMillis();
		Scanner sc = null;
		ArrayList<String> sopaLetras = new ArrayList<String>();
		ArrayList<String> palavras = new ArrayList<String>();
		
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.contentEquals(line.toUpperCase())) {
				sopaLetras.add(line);
			} else {
				String[] temp = line.split(",|;|\\s");
				int len = temp.length;
				for (int i = 0; i < len; i++) {
					palavras.add(temp[i]);
				}
				
			}
		}
		Puzzle puzz_1 = new Puzzle(sopaLetras, palavras);
		
		puzz_1.findWordsHorizontal();
		puzz_1.findWordsVertical();
		puzz_1.findWordsDiagonal();
		
		long finishT = System.currentTimeMillis();
		long elapsedT = finishT - startT;
		if (timing) {System.out.println("Elapsed Time (secs):" + elapsedT*0.001);}
		puzz_1.printResults();
		
	}

}
