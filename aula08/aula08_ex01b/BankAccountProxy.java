package aula08_ex01b;

public class BankAccountProxy implements BankAccount {
	
	private BankAccount bankaccount;
	
	BankAccountProxy(BankAccount bankaccount) {
		this.bankaccount = bankaccount;
	}
	

	@Override
	public void deposit(double amount) {
		this.bankaccount.deposit(amount);
	}

	@Override
	public boolean withdraw(double amount) {
		if (Company.user == User.OWNER) {
			return bankaccount.withdraw(amount);
		} else {
			throw new RuntimeException("ERROR! Access denied!");
		}
		
	}

	@Override
	public double balance() {
		if (Company.user == User.OWNER) {
			return bankaccount.balance();
		} else {
			throw new RuntimeException("ERROR! Access denied!");
		}
	}

}
