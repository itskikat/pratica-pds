package lab0701;

import java.util.Date;

public abstract class EmployeeDecorator implements EmployeeInterface{
	protected EmployeeInterface emp;
	
	EmployeeDecorator(EmployeeInterface emp){
		this.emp=emp;
	}
	
	public void start(Date d) {
		emp.start(d);
	}
	public void terminate(Date d) {
		emp.terminate(d);
	}
	public void work() {
		emp.work();
	}
	
}
