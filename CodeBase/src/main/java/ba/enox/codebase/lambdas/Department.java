package ba.enox.codebase.lambdas;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private List<Employee> employees;

	public Department(String name) {
		super();
		this.name = name;
		employees = new ArrayList<>();
	}

	public void addEmplyee(Employee e) {
		employees.add(e);
	}

	public List<Employee> getEmployees() {
		return employees;
	}

}
