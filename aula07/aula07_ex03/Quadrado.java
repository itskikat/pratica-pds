package lab0703;

public class Quadrado implements Figure{
	private String name;

    public Quadrado(String name) {
        this.name = name;
    }
	public String toString(){
		return "\tQuadrado "  + name;
	}

}
