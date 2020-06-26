package aula11_ex03;

public class Inventario implements State {

	@Override
	public void registar(Livro livro) {
		livro.setState(new Disponivel());
		
	}

	@Override
	public void requisitar(Livro livro) {
		throw new UnsupportedOperationException("Operacao nao suportada!");
		
	}

	@Override
	public void devolver(Livro livro) {
		throw new UnsupportedOperationException("Operacao nao suportada!");
		
	}

	@Override
	public void reservar(Livro livro) {
		throw new UnsupportedOperationException("Operacao nao suportada!");
		
	}

	@Override
	public void cancelar(Livro livro) {
		throw new UnsupportedOperationException("Operacao nao suportada!");
		
	}

}
