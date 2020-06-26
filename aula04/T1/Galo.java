package aula03;

public class Galo implements JGaloInterface{
	private int mov=0; //numero de movimentos
	private char nextplayer = 'X';
	private char result = ' ';
	private char [][] tabuleiro = new char[3][3];
	
	public char getActualPlayer() {
		return this.nextplayer;
	}

	public boolean setJogada(int lin, int col) {
		mov++;
		char currplayer = this.getActualPlayer();
		tabuleiro[lin-1][col-1] = currplayer;
		//mudar para o jogador seguinte
		if (currplayer == 'X'){
			nextplayer = 'O';
		}
		else {
			nextplayer = 'X'; 
		}
		return false;
	}

	public boolean isFinished() {
		boolean finish = false;
		//caso o numero de moves seja 9 ou tenha sido encontrado algum vencedor
		if (this.mov == 9 || (this.checkResult() == 'X' || this.checkResult() == 'O')) {
			finish = true;
		}
		return finish;
	}

	
	public char checkResult() {
		int resxh=0,resoh=0,resxv=0,resov = 0;
		//resxh = resultado X horizontal;resoh = resultado O horizontal;resxv = resultado X vertical;resov = resultado O vertical
		//verificar horizontal e vertical
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				//horizontal
				if(tabuleiro[i][j] == 'X') {
					resxh += 1;
				}
				else if(tabuleiro[i][j] == 'O') {
					resoh += 1;
				}
				//vertical
				if(tabuleiro[j][i] == 'X') {
					resxv += 1;
				}
				else if(tabuleiro[j][i] == 'O') {
					resov += 1;
				}
				
			}
			if (resxh == 3 || resxv == 3) {
				return 'X';
			}
			else if(resoh == 3 || resov == 3) {
				return 'O';
			}

			//dar reset aos valores no final de cada linha/coluna verificada
			resxh = 0;
			resoh = 0;		
			resxv = 0;
			resov = 0;
		}
		
		//diagonal
		if (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') {
			return 'X';
		}
		else if(tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') {
			return 'O';
		}
		if (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X') {
			return 'X';
		}
		else if(tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O') {
			return 'O';
		}
		
		return result;
	}
}
