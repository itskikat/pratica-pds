package aula11_ex01;

import java.util.*;

public class Descendente implements Strategy {

	@Override
	public List<Telemovel> sortingStrategy(List<Telemovel> revista, String atributo) {
		
		if(atributo.toUpperCase() == "PROCESSADOR")
			revista.sort(Comparator.comparing(Telemovel::getProcessador).reversed());
		else if(atributo.toUpperCase() == "PRECO")
			revista.sort(Comparator.comparing(Telemovel::getPreco).reversed());
		else if(atributo.toUpperCase() == "MEMORIA")
			revista.sort(Comparator.comparing(Telemovel::getMemoria).reversed());
		else if(atributo.toUpperCase() == "CAMARA")
			revista.sort(Comparator.comparing(Telemovel::getCamara).reversed());
		else
			revista.sort(Comparator.comparing(Telemovel::getNome).reversed());
		return revista;
	}
}
