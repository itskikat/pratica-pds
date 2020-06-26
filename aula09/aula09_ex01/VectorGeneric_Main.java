package aula09_ex01;

import java.util.Iterator;
import java.util.ListIterator;

public class VectorGeneric_Main {
	
	public static void main(String[] args) {
		
		VectorGeneric<String> vp = new VectorGeneric<>();
		
		for (int i = 0; i < 10; i++) {
			vp.addElem("test" + i);
		}
		
		// Default Iterator Testing
		Iterator<String> vec = vp.iterator();
		while (vec.hasNext()) {
			System.out.println(vec.next());
		}
		
		// Default ListIterator Testing
		ListIterator<String> vecLI = vp.listIterator();
		while (vecLI.hasNext()) {
			System.out.println("Next Elem: " + vecLI.next());
			System.out.println("Next Index: " + vecLI.nextIndex() + " Previous Index: " + vecLI.previousIndex());
		}
		while (vecLI.hasPrevious()) {
			System.out.println("Prev Elem: " + vecLI.previous());
			System.out.println("Next Index: " + vecLI.nextIndex() + " Previous Index: " + vecLI.previousIndex());
		}
		
		// Default ListIterator Testing
		ListIterator<String> vecLInd = vp.listIterator(3);
		while (vecLInd.hasNext()) {
			System.out.println("Next Elem: " + vecLI.next());
			System.out.println("Next Index: " + vecLI.nextIndex() + " Previous Index: " + vecLI.previousIndex());
		}
		while (vecLInd.hasPrevious()) {
			System.out.println("Prev Elem: " + vecLI.previous());
			System.out.println("Next Index: " + vecLI.nextIndex() + " Previous Index: " + vecLI.previousIndex());
		}
	}

}
