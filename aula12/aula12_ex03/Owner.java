package aula12_ex03;

public class Owner {

	private String nome;
	
	public Owner(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "{ Name: " + this.nome + " }";
	}
}
