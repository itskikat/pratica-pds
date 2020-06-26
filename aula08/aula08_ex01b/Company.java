package aula08_ex01b;

import java.util.*;

public class Company {
	
	public static User user;
	private List<Employee> emps = new ArrayList<>();
	
	public void admitEmployee(Person p, double s) {
		Employee e = new Employee(p, s);
		emps.add(e);
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount(); 
			ba.deposit(e.getSalary());
		} 	
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

}
