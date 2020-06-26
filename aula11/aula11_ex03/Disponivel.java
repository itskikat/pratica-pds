package aula11_ex03;

public class Disponivel implements State {

	@Override
	public void registar(Livro livro) {
		throw new UnsupportedOperationException("Operacao nao suportada!");
		
	}

	@Override
	public void requisitar(Livro livro) {
		livro.setState(new Emprestado());
		
	}

	@Override
	public void devolver(Livro livro) {
		throw new UnsupportedOperationException("Operacao nao suportada!");
		
	}

	@Override
	public void reservar(Livro livro) {
		livro.setState(new Reservado());
		
	}

	@Override
	public void cancelar(Livro livro) {
		throw new UnsupportedOperationException("Operacao nao suportada!");
		
	}

}
