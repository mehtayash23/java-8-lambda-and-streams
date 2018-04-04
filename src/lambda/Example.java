package lambda;

public class Example {

	public static void main(String[] args) {
		MyInterface impl = (inputString) -> System.out.println(inputString);
		impl.printMe("Manchester United");
	}

}
