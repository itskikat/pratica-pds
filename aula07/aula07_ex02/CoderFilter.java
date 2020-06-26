package aula07_TextProcessing;

import java.io.FileNotFoundException;
import java.util.Random;

public class CoderFilter extends Filters {

	public CoderFilter(ProcessingInterface pf) throws FileNotFoundException {
		super(pf);
		// TODO Auto-generated constructor stub
	}

	
	  @Override public String next() { 
		  return codificacao(super.next());
	  
	  }
	  
	  
	  private String codificacao(String palavra) { 
		  StringBuilder cifrado = new StringBuilder(palavra); 
		  Random r = new Random();
	  
		  for(int i=0; i<cifrado.length(); i++) { 
			  cifrado.setCharAt(i, (char)(65 + r.nextInt(25))); 
		  } 
		  return cifrado.toString(); }
	
}
