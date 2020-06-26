package aula06_PST;

public interface Registry_AdapterInterface {
	
	// Adapter entere Sweets-Database e Petiscos-Registos
	
	public void addEmployee (Employee employee);
	public void addEmployee (Empregado empregado);
	
	public void remEmployee (long employee_code);
	
	public boolean isEmployee (long employee_code);
	
	public void listAllEmployees();
	
	
}
