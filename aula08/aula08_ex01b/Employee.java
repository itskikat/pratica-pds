package aula08_ex01b;

public class Employee {

	  private double salary; 
	  private Person person; 
	  private BankAccount bankAccount;
	  
	  public Employee(Person p, double s) { 
		  person = p;
		  bankAccount = new BankAccountImpl("PeDeMeia", 0); 
		  salary = s; 
	  }
	  
	  public double getSalary() { 
		  return salary; 
	  }
	  
	  public BankAccount getBankAccount() { 
		  return new BankAccountProxy(bankAccount); 
	  }

}




 