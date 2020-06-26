package aula06_PST;

public class main01 {
	
	public static void main(String[] args) {
		// Sweets Testing
		Database SweetsDB = new Database();
		Employee SweetsEmp1 = new Employee("Joao Silva", 123456, 2000);
		Employee SweetsEmp2 = new Employee("Maria Antonia", 654321, 1700);
		
		System.out.println("[SWEETS] Teste ADD");
		SweetsDB.addEmployee(SweetsEmp1);
		SweetsDB.addEmployee(SweetsEmp2);
		for(Employee SweetsEmp: SweetsDB.getAllEmployees()) {
			System.out.println("EMPLOYEE: [name: " + SweetsEmp.getName() + 
					", empNum: " + SweetsEmp.getEmpNum() + 
					", salary: " + SweetsEmp.getSalary() + 
					"]");
		}
		
		System.out.println("[SWEETS] Teste REMOVE");
		SweetsDB.deleteEmployee(SweetsEmp1.getEmpNum());
		for(Employee SweetsEmp: SweetsDB.getAllEmployees()) {
			System.out.println("EMPLOYEE: [name: " + SweetsEmp.getName() + 
					", empNum: " + SweetsEmp.getEmpNum() + 
					", salary: " + SweetsEmp.getSalary() + 
					"]");
		}
		
		System.out.println();
		
		// Petiscos Testing
		Registos PetiscosReg = new Registos();
		Empregado PetiscosEmp1 = new Empregado("Artur", "Mota", 735593, 1500);
		Empregado PetiscosEmp2 = new Empregado("Natercia", "Santos", 284532, 1900);
		
		System.out.println("[PETISCOS] Teste INSERE");
		PetiscosReg.insere(PetiscosEmp1);
		PetiscosReg.insere(PetiscosEmp2);
		for(Empregado PetiscosEmp: PetiscosReg.listaDeEmpregados()) {
			System.out.println("EMPREGADO: [nome: " + PetiscosEmp.nome() + 
					", apelido: " + PetiscosEmp.apelido() + 
					", codigo: " + PetiscosEmp.codigo() + 
					", salario: " + PetiscosEmp.salario() + 
					"]");
		}
		
		System.out.println("[PETISCOS] Teste REMOVE");
		PetiscosReg.remove(PetiscosEmp1.codigo());
		for(Employee SweetsEmp: SweetsDB.getAllEmployees()) {
			System.out.println("EMPLOYEE: [name: " + SweetsEmp.getName() + 
					", empNum: " + SweetsEmp.getEmpNum() + 
					", salary: " + SweetsEmp.getSalary() + 
					"]");
		}
		
		System.out.println("[PETISCOS] Teste ISEMPREGADO");
		System.out.println("657492 e empregado? " + PetiscosReg.isEmpregado(657492));
		System.out.println("Natercia Santos e empregado? " + PetiscosReg.isEmpregado(PetiscosEmp2.codigo()));
		
		
	}

}
