package aula11_ex03;

public class Livro {
	
	private String titulo;
	private int isbn;
	private int ano;
	private String primeiroAutor;
	
	private State estado;
	
	public Livro(String titulo, int isbn, int ano, String primeiroAutor) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.ano = ano;
		this.primeiroAutor = primeiroAutor;
		this.estado = new Inventario();
	}
	
	public void setState(State s) {
		this.estado = s;
	}
	
	public void registar() {
		this.estado.registar(this);
	}
	
	public void requisitar() {
		this.estado.requisitar(this);
	}
	
	public void devolver() {
		this.estado.devolver(this);
	}
	
	public void reservar() {
		this.estado.reservar(this);
	}
	
	public void cancelar() {
		this.estado.cancelar(this);
	}
	
	@Override
	public String toString() {
        return String.format("%-5d %-20s %-20s %-15s", this.isbn, this.titulo, this.primeiroAutor,
                "[" + this.estado.getClass().getSimpleName() + "]");
    }

}
