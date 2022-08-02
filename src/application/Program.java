package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento: ");
		String deptName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefone: ");
		String phone = sc.next();
		
		Address address = new Address(email, phone);
		Department department = new Department(deptName, payDay, address);
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Dados do funcionário " + (i+1) + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String empName = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			Employee emp = new Employee(empName, salary);
			department.addEmployee(emp);
		}
		
		System.out.println();
		showReport(department);
				
		sc.close();
	}
	
	private static void showReport(Department dept) {
		StringBuilder sb = new StringBuilder();
		sb.append("FOLHA DE PAGAMENTO:\n");
		sb.append("Departamento ");
		sb.append(dept.getName());
		sb.append(" = R$ ");
		sb.append(String.format("%.2f", dept.payroll()) + "\n");
		sb.append("Pagamento realizado no dia ");
		sb.append(dept.getPayDay() + "\n");
		sb.append("Funcionários:\n");
		for (Employee e : dept.getEmployees()) {
			sb.append(e.getName() + "\n");
		}
		sb.append("Para dúvidas favor entrar em contato: ");
		sb.append(dept.getAddress().getEmail());
		System.out.println(sb.toString());
	}
}
