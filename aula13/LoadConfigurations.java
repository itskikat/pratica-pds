package aula13;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.*;
import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;

public class LoadConfigurations {
	
	private XMLConfiguration config;
	private int rows;
	private int cols;
	private int nrShips = 0;
	private String[][] theBoard;
	private ArrayList<Ship> computerShips;
	
	public LoadConfigurations(String filename) {
		File f = null;
		try {
			f = new File(filename);
		} catch (Exception e) {
			System.out.println("ERROR! Invalid file name!");
		}
		//Load the configuration from the xml file
		this.config = new XMLConfiguration((HierarchicalConfiguration<ImmutableNode>) f);
	}
	
	public void buildBoard() throws ConfigurationException {
		//Retrieve a simple configuration: (int)
		this.rows = this.config.getInt("board.rows");
		this.cols = this.config.getInt("board.collumns");
		String[][] temp = new String[this.rows][this.cols];
		this.theBoard = temp;
	}
	
	public void getComputerShips() {
		ArrayList<Ship> aux = new ArrayList<Ship>();
		List<HierarchicalConfiguration<ImmutableNode>> shipCnfs = this.config.configurationsAt("ships.ship"); 
		for(HierarchicalConfiguration shipC : shipCnfs){
			String name = shipC.getString("name");
			int number = shipC.getInt("number");
			int size = shipC.getInt("size");
			Ship s = new Ship(name, number, size);
			aux.add(s);
			this.nrShips++;
		}
		List<HierarchicalConfiguration<ImmutableNode>> complexS = this.config.configurationsAt("ships.complex-ship"); 
		for(HierarchicalConfiguration ship : complexS){
			String name = ship.getString("name");
			int number = ship.getInt("number");
			List<Integer> rows = ship.configurationsAt("matrix");
			Ship s = new Ship(name, number, rows);
			aux.add(s);
			this.nrShips++;
		}
		this.computerShips = aux;
	}
	
	public void setComputerShips(){
        System.out.println("\nComputer is deploying ships");
        //Deploying five ships for computer
        for (int i = 1; i <= this.computerShips.size(); i++) {
        	Ship s = this.computerShips.get(i-1);
        	int size = s.getSize();
            int x = (int)(Math.random() * this.rows);
            int y = (int)(Math.random() * this.cols);

            if((x >= 0 && x < this.rows) && (y >= 0 && y < this.cols) && (this.theBoard[x][y] == " "))
            {
            	if (size == 1) {
            		this.theBoard[x][y] =   "x";
                    System.out.println(i + ". ship DEPLOYED");
                    i++;
                    break;
            	}
            	// ship bigger than 1 ?
            	else {
            		this.theBoard[x][y] =   "x";
            		
            	}
                
            }
        }
        printTheBoard();
    }
	
	public void printTheBoard(){
        System.out.println();
        //First section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < this.cols; i++)
            System.out.print(i);
        System.out.println();

        //Middle section of Ocean Map
        for(int x = 0; x < this.theBoard.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < this.theBoard[x].length; y++){
                System.out.print(this.theBoard[x][y]);
            }

            System.out.println("|" + x);
        }

        //Last section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < this.cols; i++)
            System.out.print(i);
        System.out.println();
    }

}
