package aula09_ex01;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
	
	private T[] vec;
	private int nElem;
	private final static int ALLOC = 50;
	private int dimVec = ALLOC;
	
	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}
	
	private void ensureSpace() {
		if (nElem >= dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem);
			vec = newArray;
		}
	}
	
	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1);
				vec[--nElem] = null; // libertar ultimo objeto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}
	
	// iterator
	public Iterator<T> iterator(){
		return (this).new VectorIterator<T>();
	}
	
	// From TP Slides
	private class VectorIterator<K> implements Iterator<K>{
		private int indice;
		
		VectorIterator(){
			this.indice = 0;
		}
		
		public boolean hasNext() {
			return (indice < nElem);
		}
		
		public K next() {
			if (hasNext())
				return (K)VectorGeneric.this.vec[indice++];
			throw new NoSuchElementException("only " + nElem + " elements");
		}
	}
	
	
	public ListIterator<T> listIterator() {
		return new VectorListIterator<T>(0);
	}
	
	public ListIterator<T> listIterator (int index) {
		return new VectorListIterator<T>(index);
	}
	
	private class VectorListIterator<K> implements ListIterator<K> {
		private int indice;
		
		VectorListIterator(int indice) {
			this.indice = indice;
		}

		@Override
		public boolean hasNext() {
			return (indice < nElem);
		}

		@Override
		public K next() {
			if (hasNext())
				return (K)VectorGeneric.this.vec[indice++];
			throw new NoSuchElementException("only " + nElem + " elements");
		}

		@Override
		public boolean hasPrevious() {
			return (indice > 0);
		}

		@Override
		public K previous() {
			if (hasPrevious())
				return (K)VectorGeneric.this.vec[indice--];
			throw new NoSuchElementException("only " + nElem + " elements");
		}

		@Override
		public int nextIndex() {
			int ret = indice;
			return ret++; 
		}

		@Override
		public int previousIndex() {
			int ret = indice;
			return ret--;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("ERROR! Unsupported operation!");
		}
		@Override
		public void set(K e) {
			throw new UnsupportedOperationException("ERROR! Unsupported operation!");	
		}
		@Override
		public void add(K e) {
			throw new UnsupportedOperationException("ERROR! Unsupported operation!");			
		}
	}
	
	
}
