package aula09_ex02;

import java.util.ArrayList;

public class Command_Main {
	
	public static void main (String[] args) {
		
		ArrayList<String> myCol = new ArrayList<>();
		// Commands
		CommandAdd addC = new CommandAdd(myCol);
		CommandRemove removeC = new CommandRemove(myCol);
		
		addC.execute("elem1");
		addC.execute("elem2");
		System.out.println("My Collection after 2 adds: " + myCol);
		addC.undo();
		System.out.println("My Collection after undo: " + myCol);
		
		addC.execute("elem2");
		removeC.execute("elem1");
		System.out.println("My Collection after 1 remove: " + myCol);
		removeC.undo();
		System.out.println("My Collection after undo: " + myCol);
		
		
	}

}
