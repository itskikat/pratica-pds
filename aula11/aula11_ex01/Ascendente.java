package aula11_ex01;

import java.util.*;

public class Ascendente implements Strategy {

	@Override
	public List<Telemovel> sortingStrategy(List<Telemovel> revista, String atributo) {
		
		if(atributo.toUpperCase() == "PROCESSADOR")
			revista.sort(Comparator.comparing(Telemovel::getProcessador));
		else if(atributo.toUpperCase() == "PRECO")
			revista.sort(Comparator.comparing(Telemovel::getPreco));
		else if(atributo.toUpperCase() == "MEMORIA")
			revista.sort(Comparator.comparing(Telemovel::getMemoria));
		else if(atributo.toUpperCase() == "CAMARA")
			revista.sort(Comparator.comparing(Telemovel::getCamara));
		else
			revista.sort(Comparator.comparing(Telemovel::getNome));
		return revista;
	}

}
