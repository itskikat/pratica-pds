package aula03;

import java.util.Comparator;

class NameComparator implements Comparator<Familia> 
{ 
	@Override
	public int compare(Familia fam1, Familia fam2) {
		if (fam1.getMembros().get(0).compareTo(fam2.getMembros().get(0)) > 0) {
			return 1;
		} else if (fam1.getMembros().get(0).compareTo(fam2.getMembros().get(0)) < 0) {
			return -1;
		} else {
			return 0;
		} 
	} 
} 
