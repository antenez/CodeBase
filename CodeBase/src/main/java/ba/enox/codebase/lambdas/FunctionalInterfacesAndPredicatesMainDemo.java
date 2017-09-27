package ba.enox.codebase.lambdas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesAndPredicatesMainDemo {
	public static void main(String[] args) {
		Employee eno = new Employee("Eno", 25);
		Employee mile = new Employee("Mile", 60);
		Employee dejo = new Employee("Dejan", 18);
		Employee twentyEigth = new Employee("28YearsOld", 28);
		Employee thirty = new Employee("30YearsOld", 30);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(eno);
		employees.add(mile);
		employees.add(dejo);
		employees.add(twentyEigth);
		employees.add(thirty);
		
		employees.forEach(employee->{
			System.out.println("+++Name "+employee.getName());
			System.out.println("+++Age "+employee.getAge());
		});
		
		//print employes older then 25s
		System.out.println("Older then 25");
		System.out.println("=============");
		employees.forEach(employee->{
			if(employee.getAge()>25)
				System.out.println(employee.getName());
		});
		
		System.out.println("\n\nPredicateTest");
		printEmployeeByAge(employees, "Over 27", employee->employee.getAge()>27);
		printEmployeeByAge(employees, "Les then 27", employee->employee.getAge()<27);
		//anonimus class exampple
		printEmployeeByAge(employees, "Les then 27", new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				// TODO Auto-generated method stub
				return t.getAge()<27;
			}
			
		});
		
		IntPredicate greaterThen15 = var-> var>25;
		IntPredicate lessThen100 = var-> var<100;
		System.out.println("i >25 "+ greaterThen15.test(100));
		System.out.println(">15 < 100 "+greaterThen15.and(lessThen100).test(68));
		
		Random random = new Random();
		Supplier<Integer> intSuplier = ()->random.nextInt(1000);
		for(int i=0;i<10;i++){
			System.out.println(intSuplier.get());
		}
		
		
		
	}
	
	
	private static void printEmployeeByAge(List<Employee>employees, String ageText, Predicate<Employee>condition){
		System.out.println("\n\nOlder then "+ageText);
		System.out.println("=============");
		for(Employee employee: employees){
			if(condition.test(employee)){
				System.out.println(employee.getName()+" "+employee.getAge());
				}
		}
	}
}
