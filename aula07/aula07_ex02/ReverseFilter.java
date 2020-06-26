package aula07_TextProcessing;

import java.io.FileNotFoundException;

public class ReverseFilter extends Filters {

	public ReverseFilter(ProcessingInterface pf) throws FileNotFoundException {
		super(pf);
	}
	
	@Override
	public String next() {
		String palavra = super.next();
		StringBuilder reversed = new StringBuilder(palavra).reverse();
		return reversed.toString();
	}

}
