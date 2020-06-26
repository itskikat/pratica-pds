package lab0701;

import java.util.Date;

public class TeamMember extends EmployeeDecorator{
	
	TeamMember(EmployeeInterface emp) {
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
		System.out.println("\t -TeamMember");
		this.colaborate();
	}
	public void colaborate() {
		System.out.println("\t -Colaborates");
	}
}
