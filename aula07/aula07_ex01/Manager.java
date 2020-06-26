package lab0701;

import java.util.Date;

public class Manager  extends EmployeeDecorator{

	Manager(EmployeeInterface emp) {
		super(emp);
	}

	@Override
	public void start(Date d) {
		super.start(d);
	}

	@Override
	public void terminate(Date d) {
		super.terminate(d);
	}

	@Override
	public void work() {
		super.work();
		System.out.println("\t -Manager");
		this.manage();
	}
	public void manage() {
		System.out.println("\t -Manages");
	}
}
