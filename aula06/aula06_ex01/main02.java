package aula06_PST;

public class main02 {
	
	public static void main(String[] args) {

		Database SweetsDB = new Database();
		Registos PetiscosReg = new Registos();
		Registry_AdapterInterface Registry = new Registry_Adapter(SweetsDB, PetiscosReg);
		
		System.out.println("[ADAPTER] Teste ADD");
		for(int k=12345, n=0; k<12350 && n<5; k++, n++) {
			Registry.addEmployee(new Employee("Name"+n, k, k*3));
			Registry.addEmployee(new Empregado("Name"+n, "Last"+(n*2), k/3, k*2));
		}
		Registry.listAllEmployees();
		
		System.out.println();
		
		System.out.println("[ADAPTER] Teste REMOVE");
		for(int k=12345; k<12349; k++) {
			Registry.remEmployee(k);
		}
		Registry.listAllEmployees();
		
		System.out.println();
		
		System.out.println("[ADAPTER] Teste ISEMPLOYEE");
		for(int k=12345; k<12355; k++) {
			System.out.println("EmpNum: " + k + " is employee? " + Registry.isEmployee(k));
		}
		
		
	}

}
