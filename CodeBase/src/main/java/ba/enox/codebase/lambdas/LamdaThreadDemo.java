package ba.enox.codebase.lambdas;

public class LamdaThreadDemo {

	public static void main(String[] args) {
		// Normal ussage of interface
		new Thread(new CodeTorun()).start();

		// Anonymous class
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Printing From the Anonymous class runnable");

			}
		}).start();

		// Lambda case
		new Thread(() -> System.out.println("PRinting from Lambda")).start();

		// Lambda case multiple lines
		new Thread(() -> {
			System.out.println("Printing from Lambda");
			System.out.println("New Line from Lambda");

		}).start();
		;
	}
}

/*
 *	Interface with one operation implementation. Called 
	@FunctionalInterface and it is marked liek that in documentation
 */
class CodeTorun implements Runnable {

	@Override
	public void run() {
		System.out.println("Printing From the runnable");
	}

}
