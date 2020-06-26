package aula03;

import java.util.Comparator;

public class DefaultComparator implements Comparator<Familia> 
{ 
	@Override
	public int compare(Familia fam1, Familia fam2) {
		if (fam1.getIntervalo() < fam2.getIntervalo()) {
			return 1;
		} else if (fam1.getIntervalo() > fam2.getIntervalo()) {
			return -1;
		} else {
			return 0;
		} 
	} 

}
