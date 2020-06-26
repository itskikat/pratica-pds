package aula07_TextProcessing;

import java.io.FileNotFoundException;
import java.util.*;

public abstract class Filters implements ProcessingInterface {
	
	protected ProcessingInterface pf;
	protected ArrayList<String> paragrafo;
	
	public Filters (ProcessingInterface pf) throws FileNotFoundException {
		this.pf = pf;
		this.paragrafo = new ArrayList<String>();
	}
	
	@Override
	public boolean hasNext() {
		return this.pf.hasNext();
	}

	@Override
	public String next() {
		// Paragrafo vazio
		if (this.paragrafo.size() == 0) {
			String para = this.pf.next();
			for(String palavra: para.split(" ")) {
				this.paragrafo.add(palavra);
			}
		}
		
		return this.paragrafo.remove(0);
	}

}
