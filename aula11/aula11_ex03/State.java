package aula11_ex03;

public interface State {

	public void registar(Livro livro);
	public void requisitar(Livro livro);
	public void devolver(Livro livro);
	public void reservar(Livro livro);
	public void cancelar(Livro livro);
}
