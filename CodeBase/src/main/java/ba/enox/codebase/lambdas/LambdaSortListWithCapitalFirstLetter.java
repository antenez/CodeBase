package ba.enox.codebase.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ba.enox.codebase.algorithms.string.SysOutInDemo;

public class LambdaSortListWithCapitalFirstLetter {

	public static void main(String[] args) {
		/*
		 * Sort list of string with upper case first string
		 */

		List<String> names = Arrays.asList("Eno", "salahudin", "omer", "osman");
		List<String> firstUpperCaseListWithSortedItems = new ArrayList<>();
		names.forEach(s -> {
			firstUpperCaseListWithSortedItems.add(s.substring(0, 1).toUpperCase() + s.substring(1));
		});
		System.out.println("-----------Reversed");
		firstUpperCaseListWithSortedItems.sort((s1, s2) -> s2.compareTo(s1));
		firstUpperCaseListWithSortedItems.forEach(s -> System.out.println("Name:" + s));
		
		//same with method refference to regular order
		System.out.println("-----------Regular");
		firstUpperCaseListWithSortedItems.sort(String::compareTo);
		firstUpperCaseListWithSortedItems.forEach(System.out::println);
		
		
		//Test with streams 
		System.out.println("-----------Streams and update same object");
		names.forEach(System.out::println);
		System.out.println("-----------");
		names.stream().map(name -> name.substring(0,1).toUpperCase()+name.substring(1)).sorted(String::compareTo).forEach(System.out::println);
		System.out.println("---");
		names.forEach(s-> System.out.println("Name:"+s));//This prove that original list is not changed
		
		
		//Count from stream by criteria
		System.out.println("-----------Count from stream by criteria");
		long  countBeginsWithO = names.stream().map(name -> name.substring(0,1).toUpperCase()+name.substring(1))
				.filter(name->name.startsWith("O"))
				.count();
		System.out.println("Count starts with O "+countBeginsWithO);
		
		
		

	}
}
