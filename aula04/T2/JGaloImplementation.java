package aula03;

public class JGaloImplementation implements JGaloInterface{
	char jogadorAtual;
	char[][] tabela;
	char vencedor;
			
	public JGaloImplementation(char jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
		this.tabela = new char[3][3];
		
	}
	
	@Override
	public char getActualPlayer() {
		if (jogadorAtual == 'X') {
			return 'X';
		} else {
			return 'O';
		}
	}

	@Override
	public boolean setJogada(int lin, int col) {
		this.tabela[lin-1][col-1] = this.jogadorAtual;
		if (jogadorAtual == 'X') {
			jogadorAtual = 'O';
		} else {
			jogadorAtual = 'X';
		}
		return false;
	}

	@Override
	public boolean isFinished() {
		boolean empate = true;
		// Verificação Vitória na Linha
		for (int l = 0; l<tabela.length; l++) {
			if ((this.tabela[l][0] == 'X' || this.tabela[l][0] == 'O') && this.tabela[l][0] == this.tabela[l][1] && this.tabela[l][0] == this.tabela[l][2]) {
				vencedor = this.tabela[l][0];
				return true;
			}
			if (this.tabela[l][0] == '\u0000' || this.tabela[l][1] == '\u0000' || this.tabela[l][2] == '\u0000') {
				empate = false;
			}
		}
		
		// Verificação Vitória na Coluna
		for (int c = 0; c<tabela.length; c++) {
			if ((this.tabela[0][c] == 'X' || this.tabela[0][c] == 'O') && this.tabela[0][c] == this.tabela[1][c] && this.tabela[0][c] == this.tabela[2][c]) {
				vencedor = this.tabela[0][c];
				return true;
			} 
			if (this.tabela[0][c] == '\u0000' || this.tabela[1][c] == '\u0000' || this.tabela[2][c] == '\u0000') {
				empate = false;
			}
		}
		
		// Verificação Vitória na Diagonal
		if ((this.tabela[0][0] == 'X' || this.tabela[0][0] == 'O') && this.tabela[0][0] == this.tabela[1][1] && this.tabela[1][1] == this.tabela[2][2]) {
			vencedor = this.tabela[0][0];
			return true;
		} else if ((this.tabela[2][0] == 'X' || this.tabela[2][0] == 'O') && this.tabela[2][0] == this.tabela[1][1] && this.tabela[1][1] == this.tabela[0][2]) {
			vencedor = this.tabela[2][0];
			return true;
		}
		
		if (this.tabela[0][0] == '\u0000' || this.tabela[1][1] == '\u0000' || this.tabela[2][2] == '\u0000' || this.tabela[2][0] == '\u0000' || this.tabela[0][2] == '\u0000') {
			empate = false;
		}
		
		if (empate == true) {
			vencedor = ' ';
			return true;
		}
		
		return false;
	}

	@Override
	public char checkResult() {
		return vencedor;
	}

}
