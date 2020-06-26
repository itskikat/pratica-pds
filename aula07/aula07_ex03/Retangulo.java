package lab0703;

public class Retangulo implements Figure{
	private String name;

    public Retangulo(String name) {
        this.name = name;
    }
	public String toString(){
		return "\tRetangulo "  + name;
	}

}
