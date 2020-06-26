package aula07_TextProcessing;

import java.io.*;
import java.util.*;

public class TextReader implements ProcessingInterface {
	
	private Scanner sc;
	
	public TextReader (String fname) throws FileNotFoundException {
		File f = new File(fname);
		this.sc = new Scanner(f);
	}

	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}

	@Override
	// Devolve um paragrafo
	public String next() {
		return sc.nextLine();
	}
	
}
