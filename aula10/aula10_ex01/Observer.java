package aula10_ex01;

public interface Observer {
	
	public abstract void update(String updateMsg);
	public abstract ObserverType type();
}
