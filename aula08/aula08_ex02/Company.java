package aula08_ex02;

import java.util.*;

public class Company {
	
	public static User user;
	private List<Employee> emps = new ArrayList<>();
	
	public void admitPerson(Person p, double s) { 
		Employee e = new Employee(p.getName(), s); 
		emps.add(e);
		SocialSecurity.regist(p);
		Insurance.regist(p);
		Card c = new Card(p);
		if (s > 1000) {
			Parking.allow(p);
		}
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
