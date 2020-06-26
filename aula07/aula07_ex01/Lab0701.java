package lab0701;
import java.util.Date;

public class Lab0701 {
	public static void main(String[] args) {
		Employee one = new Employee("Afonso");
		one.start(new Date());
		one.terminate(new Date());
		one.work();
		
		TeamLeader two = new TeamLeader(new Employee("Beatriz"));
		two.work();
		
		TeamMember three = new TeamMember(new Employee("Clara"));
		three.work();
		
		Manager four = new Manager(new Employee("Dinis"));
		four.work();
		
		Manager five = new Manager(two);
		five.work();
	}
}
