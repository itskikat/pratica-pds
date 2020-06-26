package aula13;

import java.util.*;

public class Ship {
	
	private String name;
	private int number;
	private int size;
	private List<Integer> matrix;
	
	public Ship(String name, int number, int size) {
		this.name = name;
		this.number = number;
		this.size = size;
	}
	
	public Ship(String name, int number, List<Integer> matrix) {
		this.name = name;
		this.number = number;
		this.setMatrix(matrix);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Integer> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<Integer> matrix) {
		this.matrix = matrix;
	}
	
	
	
	
	
}
