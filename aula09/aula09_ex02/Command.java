package aula09_ex02;

public interface Command<K> {
	
	public boolean execute(K element);
	public void undo();
	
}
