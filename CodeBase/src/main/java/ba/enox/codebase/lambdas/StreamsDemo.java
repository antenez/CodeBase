package ba.enox.codebase.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bingoNumbers = Arrays.asList("N1", "N25", "N30", "N60", "G35", "N65", "G45", "G15");
		List<String> gNumbers = new ArrayList<>();

		//Stream example
		bingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted()
				.forEach(s -> System.out.println("Sorded " + s));

		
		Stream<String> streamOne =  Stream.of("one1","one2","one3","one4");
		Stream<String> streamTwo =  Stream.of("two1","two2","one3","two4");
		Stream<String> concatStream = Stream.concat(streamOne, streamTwo);
		System.out.println(concatStream.distinct().peek(System.out::println).count());
		
		
		
		// Step By Step way...improvement is above wit serialized and all of
		// this can go in one statement
		bingoNumbers.forEach(number -> {
			if (number.startsWith("G")) {
				gNumbers.add(number);
				System.out.println("Gnumber " + number);
			}
		});
		gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
		gNumbers.forEach(number -> System.out.println("Sorted number " + number));
		
		
		//-------------------------------------
		Department hr = new Department("HR");
		Department it = new Department("IT");
		Employee eno = new Employee("Eno Ahmedspahic", 30);
		Employee saroy = new Employee("Saroy Nath", 35);
		Employee  marco = new Employee("Marco Sylbinder", 40);
		Employee  ilya = new Employee("Ilya Semenov", 34);
		
		hr.addEmplyee(marco);
		it.addEmplyee(eno);
		it.addEmplyee(saroy);
		it.addEmplyee(ilya);
		
		List<Department> departments = new ArrayList<>();
		departments.add(hr);
		departments.add(it);
		
		
		
		
		


		

	}

}
