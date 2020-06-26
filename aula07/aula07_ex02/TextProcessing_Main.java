package aula07_TextProcessing;

public class TextProcessing_Main {

	public static void main(String args[]) {
		
		ProcessingInterface pf;
		
		try {
			// Text Reader testing
			pf = new TextReader("pg40409.txt");
			System.out.println(pf.hasNext());
			System.out.println(pf.next());
			
			// Coder Filter testing
			pf = new CoderFilter(new TextReader("pg40409.txt"));
			System.out.println(pf.hasNext());
			System.out.println(pf.next());
			
			// Reverse Filter testing
			pf = new ReverseFilter(new TermFilter(new TextReader("pg40409.txt")));
			System.out.println(pf.hasNext());
			System.out.println(pf.next());
			
			
			
		} catch (Exception e) {
			System.err.println("Error defining interface!");
		}
			
	}
}
