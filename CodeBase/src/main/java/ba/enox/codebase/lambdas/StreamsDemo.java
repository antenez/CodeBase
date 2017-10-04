package ba.enox.codebase.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bingoNumbers = Arrays.asList("N1", "N25", "N30", "N60", "G35", "N65", "G45", "G15");
		List<String> gNumbers = new ArrayList<>();

		//Stream example
		bingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted()
				.forEach(s -> System.out.println("Sorded " + s));

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

	}

}
