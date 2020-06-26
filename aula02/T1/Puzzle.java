package P01;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.StringBuilder;

public class Puzzle {
	private int dim;
	private ArrayList<String> sopaLetras;
	private ArrayList<String> palavras;
	// HashMap que cont�m as palavras encontradas na sopa de letras e uma lista com as posi��es ocorr�ncias,
	// as posi��es vao ter o formato xx,yy|direcao
	private HashMap<String, ArrayList<String>> resultados = new HashMap<String, ArrayList<String>>();
	private String tempP;
	
	public Puzzle(ArrayList<String> sopaLetras, ArrayList<String> palavras) {
		int dim = 0;
		boolean isSquare = true;
		for (String l : sopaLetras) {
			dim = l.length();
			System.out.println(l);
			if (dim != sopaLetras.size()) {
				isSquare = false;
			}
		}
		if (isSquare) {
			this.sopaLetras = sopaLetras;
			this.palavras = palavras;
			this.dim = dim;
		} else {
			System.out.println("Dados de entrada inv�lidos.");
		}
	}
	
	public void findWordsHorizontal() {
		int posicao;
		for (String pal : palavras) {	
			for (String linha : sopaLetras) {
				
				// Da esquerda para a direita:
				posicao = linha.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(sopaLetras.indexOf(linha) + 1) + "," + String.valueOf(posicao + 1) + ":right";
					addToMap(resultados, pal);
				}
				// Da direita para a esquerda:
				String linhaReversed = new StringBuilder(linha).reverse().toString();
				posicao = linhaReversed.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(sopaLetras.indexOf(linha) + 1) + "," + String.valueOf(dim - posicao) + ":left";
					addToMap(resultados, pal);
				}
			}
		}
	}
	
	public void findWordsVertical() {
		String tempC = "";
		int posicao;
		for (int c = 0; c < dim; c++) {
			for (int l = 0; l < dim; l++) {
				tempC = tempC + String.valueOf(sopaLetras.get(l).charAt(c));
			}

			for (String pal : palavras) {
				
				// De cima para baixo:
				posicao = tempC.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(posicao + 1) + "," + String.valueOf(c + 1) + ":down";
					addToMap(resultados, pal);
				}
				
				// De baixo para cima:
				String linhaReversed = new StringBuilder(tempC).reverse().toString();
				posicao = linhaReversed.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(dim - posicao) + "," + String.valueOf(c + 1) + ":up";
					addToMap(resultados, pal);
				}
				
			}
			// Reset da coluna tempor�ria
			tempC = "";
		}
	}
	
	public void findWordsDiagonal() {
		String tempW = "";
		int posicao;
		
		// Diagonal de dim,1 para 1,dim -----
		for (int c = dim-1; c >= 0; c--) {
			for (int l = 0; l < dim - c; l++) {
				tempW = tempW + sopaLetras.get(c+l).charAt(l);
			}
			for (String pal : palavras) {
				
				// Baixo direita:
				posicao = tempW.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(c + 1) + "," + String.valueOf(posicao + 1) + ":downright";
					addToMap(resultados, pal);
				}
				
				// Cima esquerda
				String linhaReversed = new StringBuilder(tempW).reverse().toString();
				posicao = linhaReversed.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(dim - posicao) + "," + String.valueOf(dim - c - 1) + ":upleft";
					addToMap(resultados, pal);
				}
			}
			tempW = "";
		}
		
		for (int c = 1; c < dim; c++) {
			for (int l = 0; l < dim - c; l++) {
				tempW = tempW + sopaLetras.get(l).charAt(c+l);
			}
			for (String pal : palavras) {
				
				// Baixo direita:
				posicao = tempW.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(c + 1) + "," + String.valueOf(posicao + 1) + ":downright";
					addToMap(resultados, pal);
				}
				
				// Cima esquerda
				String linhaReversed = new StringBuilder(tempW).reverse().toString();
				posicao = linhaReversed.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(dim - posicao) + "," + String.valueOf(dim - c - 1) + ":upleft";
					addToMap(resultados, pal);
				}
			}
			tempW = "";
		}
		// --------------------
		
		
		// De 1,1 para dim, dim
		for (int c = 0; c < dim; c++) {
			for (int l = 0; l <= c; l++) {
				tempW = tempW + sopaLetras.get(c-l).charAt(l);
			}
			for (String pal : palavras) {
				
				// Cima direita:
				posicao = tempW.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(c+1) + "," + String.valueOf(posicao+1) + ":upright";
					addToMap(resultados, pal);
				}
				
				// Baixo esquerda
				String linhaReversed = new StringBuilder(tempW).reverse().toString();
				posicao = linhaReversed.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(posicao+1) + "," + String.valueOf(c) + ":downleft";
					//tempP = String.valueOf(posicao + 1) + "," + String.valueOf(c - posicao + 1) + ":downleft";
					addToMap(resultados, pal);
				}
			}
			tempW = "";
		}
		
		for (int c = 0; c <=dim-1; c++) {
			for (int l = dim-1; l >= c; l--) {
				tempW = tempW + sopaLetras.get(l).charAt(dim-l-1+c);
			}
			for (String pal : palavras) {
				
				// Cima direita:
				posicao = tempW.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(dim-posicao+1) + "," + String.valueOf(c+1) + ":upright";
					addToMap(resultados, pal);
				}
				
				// Baixo esquerda
				String linhaReversed = new StringBuilder(tempW).reverse().toString();
				posicao = linhaReversed.toLowerCase().indexOf(pal.toLowerCase());
				// Se existir...
				if (posicao != -1) {
					tempP = String.valueOf(posicao + 1) + "," + String.valueOf(c + 1) + ":downleft";
					//tempP = String.valueOf(c + posicao  + 1) + "," + String.valueOf(dim - posicao) + ":downleft";
					addToMap(resultados, pal);
				}
			}
			tempW = "";
		}
		
		// -------------------
		
	}

	public HashMap<String, ArrayList<String>> getResultados() {
		return resultados;
	}
	
	// Verifica se a palavra j� existe no hashmap, e adiciona a posicao � respetiva lista de posicoes da palavra
	public void addToMap (HashMap<String, ArrayList<String>> resultados, String pal) {
		if (resultados.containsKey(pal)) {
			resultados.get(pal).add(tempP);
		} else {
			resultados.put(pal, new ArrayList<String>());
			resultados.get(pal).add(tempP);
		}
	}
	
	public void printResults() {
		ArrayList<String> res = null;
		String[] posDir;
		
		for (String palavra : palavras) {
			if (resultados.containsKey(palavra)){
				res = resultados.get(palavra);
			}
			if (!res.isEmpty()) {
				for (String pD : res) {
					posDir = pD.split(":");
					System.out.printf("%-15s%-8d%-8s%-8s\n", palavra.toUpperCase(), palavra.length(), posDir[0], posDir[1]);
				}
			}
		}
	}
	
}
