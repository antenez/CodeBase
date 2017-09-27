package ba.enox.codebase.lambdas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaEmployeeDemo {

	public static void main(String[] args) {
		// Lambda case
		new Thread(() -> System.out.println("PRinting from Lambda")).start();

		Employee eno = new Employee("Eno", 25);
		Employee mile = new Employee("Mile", 60);
		Employee dejo = new Employee("Dejan", 18);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(eno);
		employees.add(mile);
		employees.add(dejo);
		
		Collections.sort(employees,new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for(Employee e: employees){
			System.out.println("Employee name "+e.getName());
		}
		
		//reverse it by lambda
		Collections.sort(employees,(e1,e2)->e2.getName().compareTo(e1.getName()));
		for(Employee e: employees){
			System.out.println("Employee name "+e.getName());
		}
		
		//upper regular way
		String testUpperCaseString = doSimpleStringStuff(new UpperConcat() {
			@Override
			public String upperAndConcat(String s1, String s2) {
				// TODO Auto-generated method stub
				return s1.toUpperCase()+" "+s2.toUpperCase();
			}
		}, employees.get(0).getName(), employees.get(1).getName()
		);
		
		System.out.println("testUpperCaseString: "+testUpperCaseString);
		
		
		//upper lambda
		UpperConcat uc = (s1,s2)->s1.toUpperCase()+" "+ s2.toUpperCase();
		testUpperCaseString = doSimpleStringStuff(uc, employees.get(1).getName(),employees.get(2).getName());
		System.out.println("testUpperCaseString: "+testUpperCaseString);
		
	}
	
	
	
	public static final String doSimpleStringStuff(UpperConcat uc, String s1 , String s2){
		return uc.upperAndConcat(s1, s2);
	}
	
	
}

interface UpperConcat{
	public String upperAndConcat(String s1, String s2);
}






