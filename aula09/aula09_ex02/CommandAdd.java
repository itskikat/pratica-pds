package aula09_ex02;

import java.util.Collection;

public class CommandAdd<K> implements Command<K> {
	
	private Collection<K> col;
	private K last;
	
	public CommandAdd(Collection<K> col) {
		this.col = col;
	}

	// adds element to collection
	@Override
	public boolean execute(K element) {
		boolean flag = this.col.add(element);
		// added element, must store it to remove it if 'undo'!
		if (flag) {
			this.last = element;
		}
		return flag;
	}

	@Override
	public void undo() {
		if (this.last != null) {
			this.col.remove(this.last);
		}
	}

}
