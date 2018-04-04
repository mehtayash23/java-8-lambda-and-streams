package lambda;

public class Example {

	public static void main(String[] args) {
		// Old way to create a thread.
		Thread thread;
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Annother thread is running..");
			}
		});

		// Create a thread with lambda expression.
		thread = new Thread(() -> System.out.println("Another thread is running..."));
		thread.start();
	}

}
