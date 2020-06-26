package aula06_PST;

import java.util.*;

public class Registry_Adapter implements Registry_AdapterInterface {

	private Database SweetsDB;
	private Registos PetiscosReg;
	
	public Registry_Adapter(Database SweetsDB, Registos PetiscosReg) {
		this.SweetsDB = SweetsDB;
		this.PetiscosReg = PetiscosReg;
	}
	
	@Override
	public void addEmployee(Employee employee) {
		SweetsDB.addEmployee(employee);	
	}

	@Override
	public void addEmployee(Empregado empregado) {
		PetiscosReg.insere(empregado);
	}

	@Override
	public void remEmployee(long employee_code) {
		SweetsDB.deleteEmployee(employee_code);
		PetiscosReg.remove((int)employee_code);
	}

	@Override
	public boolean isEmployee(long employee_code) {
		
		for(Employee employee: Arrays.asList(SweetsDB.getAllEmployees())){
			if (employee.getEmpNum() == employee_code) {
				return true;
			}
		}
		return PetiscosReg.isEmpregado((int) employee_code);
	}

	@Override
	public void listAllEmployees() {
		
		for(Employee SweetsEmp: SweetsDB.getAllEmployees()){
			System.out.println("EMPLOYEE: [name: " + SweetsEmp.getName() + 
					", empNum: " + SweetsEmp.getEmpNum() + 
					", salary: " + SweetsEmp.getSalary() + 
					"]");
		}
		
		for(Empregado PetiscosEmp: PetiscosReg.listaDeEmpregados()) {
			System.out.println("EMPREGADO: [nome: " + PetiscosEmp.nome() + 
					", apelido: " + PetiscosEmp.apelido() + 
					", codigo: " + PetiscosEmp.codigo() + 
					", salario: " + PetiscosEmp.salario() + 
					"]");
		}
		
	}
		
}
	
