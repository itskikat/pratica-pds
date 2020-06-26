package lab0701;

import java.util.Date;

public class Employee implements EmployeeInterface{
	private String name;
	private Date startDate;
	private Date endDate;
	
	public Employee (String name) {
		this.name=name;
	}
	
	@Override
	public void start(Date d) {
		startDate=d;
		System.out.println(name + " started working on " + startDate);
	}
	@Override
	public void terminate(Date d) {
		endDate=d;
		System.out.println(name + " finished working on " + endDate);
	}
	@Override
	public void work() {
		System.out.println(name + " works");
	}
}
