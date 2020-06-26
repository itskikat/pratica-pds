package lab0703;

public class Circulo implements Figure{
	private String name;

    public Circulo(String name) {
        this.name = name;
    }
	public String toString(){
		return "\tCírculo "  + name;
	}
}
