package aula03;

import java.util.ArrayList;
import java.util.Arrays;

public class Familia implements Comparable{
	final int[] localization;
	private ArrayList<String> membros;
	
	public static Familia Familia(String local) {
		String[] local2 = local.split("-");
		int[] localization = new int[2];
		if (local2.length != 2) return null;
		for (int i=0; i<2; i++) {
			try {
				localization[i] = Integer.parseInt(local2[i]);
			} catch (NumberFormatException nfe) {
				return null;
			}
			if (i==0 && localization[i]<=0) return null; //garantir que começa em 1
			if (i==1 && localization[i]<localization[i-1]) return null; //garantir que o segundo é maior ou igual ao primeiro
		}
		return new Familia(localization);
	}
	
	private Familia(int[] local) {
		membros = new ArrayList<>();
		localization = local;
	}

	public int[] getLocalization() {
		return localization;
	}
	
	public String getLocalizationString() {
		return String.valueOf(localization[0]) + "-" + String.valueOf(localization[1]);
	}

	public ArrayList<String> getMembros() {
		return membros;
	}

	public boolean addMember (String membro) {
		if (membro.length()>30 || membro.length()<3) { //garantir que o nome tem entre 3 a 30 caracteres
			return false;
		}
		
		for (String member : membros) {
			if (membro.equals(member)) return false; //o nome é único
		}
		
		if (!Character.isLetter(membro.charAt(0))) { //o nome deve começar por uma letra
			return false;
		}
		
		for (int i=1; i<membro.length()-1;i++) { //o nome tem letras, números ou _.@
			if (!Character.isLetterOrDigit(membro.charAt(i))) {
				if (membro.charAt(i) != '_') {
					if (membro.charAt(i) != '.') {
						if (membro.charAt(i) != '@') {
							return false;
						}
					}	
				}
			}
		}
		
		if (!Character.isLetterOrDigit(membro.charAt(membro.length()-1))) { //o nome não acaba com um símbolo
			return false;
		}
		
		membros.add(membro);
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(localization);
		result = prime * result + ((membros == null) ? 0 : membros.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Familia other = (Familia) obj;
		if (!Arrays.equals(localization, other.localization))
			return false;
		if (membros == null) {
			if (other.membros != null)
				return false;
		} else if (!membros.equals(other.membros))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Familia [localization=" + Arrays.toString(localization) + ", membros=" + membros + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		return -this.localization[1]+this.localization[0]+((Familia)arg0).getLocalization()[1]-((Familia)arg0).getLocalization()[0];
	}

	public boolean remove(String nome) {
		for (int i = 0; i<membros.size(); i++) {
			if (membros.get(i).equals(nome)) {
				membros.remove(i);
				return true;
			}
		}
		return false;
	}
}
