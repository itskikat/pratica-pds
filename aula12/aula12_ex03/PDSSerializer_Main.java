package aula12_ex03;

public class PDSSerializer_Main {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Ship s = new Ship("BelaRia", 200);
		s.setOwner(new Owner("Manuel"));
		s.setPassageiros(new String[] {"Manuel", "Amilcar"});
		
		System.out.println( PDSSerializer.fromObject(s));
		
	}

}
