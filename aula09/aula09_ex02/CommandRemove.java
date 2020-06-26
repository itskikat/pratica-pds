package aula09_ex02;

import java.util.Collection;

public class CommandRemove<K> implements Command<K> {
	
	private Collection<K> col;
	private K last;
	
	public CommandRemove(Collection<K> col) {
		this.col = col;
	}

	// adds element to collection
	@Override
	public boolean execute(K element) {
		boolean flag = this.col.remove(element);
		// removed element, must store it to add it if 'undo'!
		if (flag) {
			this.last = element;
		}
		return flag;
	}

	@Override
	public void undo() {
		if (this.last != null) {
			this.col.add(this.last);
		}
	}

}
