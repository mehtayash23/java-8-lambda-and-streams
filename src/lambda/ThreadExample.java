package lambda;

public class ThreadExample {

	public static void createThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread without lambda expression");
			}
		});
		thread.start();
	}

	public static void createThreadWithLambda() {
		Thread thread = new Thread(() -> System.out.println("Thread with lambda expression"));
		thread.start();
	}

	public static void main(String[] args) {
		System.out.println("In main thread...");
		createThread();
		createThreadWithLambda();
	}

}
