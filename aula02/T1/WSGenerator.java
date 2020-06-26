package P01;

import java.util.ArrayList;
import java.util.Random;

public class WSGenerator {
	int dim, nWords; // dimens�o da sopa de letras, n� de palavras
	String[][] sL;
	ArrayList<String> sopaLetras = new ArrayList<String>();
	ArrayList<String> palavras = new ArrayList<String>();
	ArrayList<String> usedPositions = new ArrayList<String>();
	
	String[] directions = {"right", "left", "down", "up", "upright", "upleft", "downright", "downleft"};
	
	public WSGenerator (ArrayList<String> palavras, int dim) {
		this.sL = new String[dim][dim];
		this.dim = dim;
		for (String pal : palavras) {
			if (pal.length() <= dim) {
				this.palavras.add(pal.toUpperCase());
			}
		}
		this.nWords = this.palavras.size();
		for (int n = 0; n < dim; n++) {
			sopaLetras.add("");
		}
	}
	
	public void generateWS() {
		Random r = new Random();
		for (int c = 0; c < dim; c++) {
			for (int l = 0; l < dim; l++) {
				char letter = (char) (r.nextInt(26) + 'a');
				sL[c][l] = String.valueOf(letter).toUpperCase();
				//sopaLetras.set(c, sopaLetras.get(c).concat(String.valueOf(letter).toUpperCase()));
			}
		}
		
		int dir, len, x, y, xV, yV, attempt;
		boolean ver, ver2;
		String position;
		for (String word : palavras) {
			
			attempt = 0;
			dir = r.nextInt(8);
			
			switch (dir) {
				case 0: //right
					len = word.length();
					ver = true;
					ver2 = true;
					while (ver && attempt < 200) {
						attempt++;
						ver2 = true;
						x = r.nextInt(dim);
						y = r.nextInt(dim);
						xV = x;
						yV = y;
						
						if (y + len < dim) {
							for (int n = 0; n < len; n++) {
								position = xV + "," + yV;
								yV++;
								if (usedPositions.contains(position)) {
									ver2 = false;
								}
							}

							if (ver2) {
								for (int n = 0; n < len; n++) {
									char temp = word.charAt(n);
									sL[x][y] = String.valueOf(temp);
									position = x + "," + y;
									usedPositions.add(position);
									y++;
								}
								ver = false;
							}
						} 
					}
					break;
				case 1: //left
					len = word.length();
					ver = true;
					while (ver && attempt < 200) {
						attempt++;
						ver2 = true;
						x = r.nextInt(dim);
						y = r.nextInt(dim);
						xV = x;
						yV = y;
						if (y - len >= 0) {
							for (int n = 0; n < len; n++) {
								position = xV + "," + yV;
								yV++;
								if (usedPositions.contains(position)) {
									ver2 = false;
								}
							}

							if (ver2) {
								for (int n = 0; n < len; n++) {
									char temp = word.charAt(n);
									sL[x][y] = String.valueOf(temp);
									position = x + "," + y;
									usedPositions.add(position);
									y--;
								}
								ver = false;
							}
						}
					}
					break;
					
				case 2://down
					len = word.length();
					ver = true;
					while (ver && attempt < 200) {
						attempt++;
						ver2 = true;
						x = r.nextInt(dim);
						y = r.nextInt(dim);
						xV = x;
						yV = y;
						if (x + len < dim) {
							for (int n = 0; n < len; n++) {
								position = xV + "," + yV;
								xV++;
								if (usedPositions.contains(position)) {
									ver2 = false;
								}
							}
							
							if (ver2) {
								for (int n = 0; n < len; n++) {
									char temp = word.charAt(n);
									sL[x][y] = String.valueOf(temp);
									position = x + "," + y;
									usedPositions.add(position);
									x++;
								}
								ver = false;
							}
						}
					}
					break;
					
				case 3://up
					len = word.length();
					ver = true;
					while (ver && attempt < 200) {
						attempt++;
						ver2 = true;
						x = r.nextInt(dim);
						y = r.nextInt(dim);
						xV = x;
						yV = y;
						if (x - len >= 0) {
							for (int n = 0; n < len; n++) {
								position = xV + "," + yV;
								xV--;
								if (usedPositions.contains(position)) {
									ver2 = false;
								}
							}
							
							if (ver2) {
								for (int n = 0; n < len; n++) {
									char temp = word.charAt(n);
									sL[x][y] = String.valueOf(temp);
									position = x + "," + y;
									usedPositions.add(position);
									x--;
								}
								ver = false;
							}
						}
					}
					break;
					
				case 4://upright
					len = word.length();
					ver = true;
					while (ver && attempt < 200) {
						attempt++;
						ver2 = true;
						x = r.nextInt(dim);
						y = r.nextInt(dim);
						xV = x;
						yV = y;
						if (x - len >= 0 && y + len < dim) {
							for (int n = 0; n < len; n++) {
								position = xV + "," + yV;
								xV--;
								yV++;
								if (usedPositions.contains(position)) {
									ver2 = false;
								}
							}
							
							if (ver2) {
								for (int n = 0; n < len; n++) {
									char temp = word.charAt(n);
									sL[x][y] = String.valueOf(temp);
									position = x + "," + y;
									usedPositions.add(position);
									x--;
									y++;
								}
								ver = false;
							}
						}
					}
					break;
				case 5://upleft
					len = word.length();
					ver = true;
					while (ver && attempt < 200) {
						attempt++;
						ver2 = true;
						x = r.nextInt(dim);
						y = r.nextInt(dim);
						xV = x;
						yV = y;
						if (x - len >= 0 && y - len >= 0) {
							for (int n = 0; n < len; n++) {
								position = xV + "," + yV;
								xV--;
								yV--;
								if (usedPositions.contains(position)) {
									ver2 = false;
								}
							}
							
							if (ver2) {
								for (int n = 0; n < len; n++) {
									char temp = word.charAt(n);
									sL[x][y] = String.valueOf(temp);
									position = x + "," + y;
									usedPositions.add(position);
									x--;
									y--;
								}
								ver = false;
							}
						}
					}
					break;
				case 6://downright
					len = word.length();
					ver = true;
					while (ver && attempt < 200) {
						attempt++;
						ver2 = true;
						x = r.nextInt(dim);
						y = r.nextInt(dim);
						xV = x;
						yV = y;
						if (x + len < dim && y + len < dim) {
							for (int n = 0; n < len; n++) {
								position = xV + "," + yV;
								xV++;
								yV++;
								if (usedPositions.contains(position)) {
									ver2 = false;
								}
							}
							
							if (ver2) {
								for (int n = 0; n < len; n++) {
									char temp = word.charAt(n);
									sL[x][y] = String.valueOf(temp);
									position = x + "," + y;
									usedPositions.add(position);
									x++;
									y++;
								}
								ver = false;
							}
						}
					}
					break;
				case 7://downleft
					len = word.length();
					ver = true;
					while (ver && attempt < 200) {
						attempt++;
						ver2 = true;
						x = r.nextInt(dim);
						y = r.nextInt(dim);
						xV = x;
						yV = y;
						if (x + len < dim && y - len >= 0) {
							for (int n = 0; n < len; n++) {
								position = xV + "," + yV;
								xV++;
								yV--;
								if (usedPositions.contains(position)) {
									ver2 = false;
								}
							}
							
							if (ver2) {
								for (int n = 0; n < len; n++) {
									char temp = word.charAt(n);
									sL[x][y] = String.valueOf(temp);
									position = x + "," + y;
									usedPositions.add(position);
									x++;
									y--;
								}
								ver = false;
							}
						}
					}
					break;					
			}
		}		
	}
	
	public void printWordSearch() {
		for (int c = 0; c < dim; c++) {
			for (int l = 0; l < dim; l++) {
				System.out.print(sL[c][l]);
			}
			System.out.println();
		}
	}
	
	public ArrayList<String> toArrayList() {
		String tempW = "";
		ArrayList<String> sLArrayList = new ArrayList<String>();
		for (int c = 0; c < dim; c++) {
			for (int l = 0; l < dim; l++) {
				tempW = tempW + sL[c][l];
			}
			sLArrayList.add(tempW);
			tempW = "";
		}
		return sLArrayList;
	}

	public String[][] getsL() {
		return sL;
	}
}
