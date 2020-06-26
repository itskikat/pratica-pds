package lab0701;

import java.util.Date;

public class TeamLeader extends EmployeeDecorator{
	
	TeamLeader(EmployeeInterface emp) {
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
		System.out.println("\t -TeamLeader");
		this.plan();
	}
	public void plan() {
		System.out.println("\t -Plans");
	}
}
