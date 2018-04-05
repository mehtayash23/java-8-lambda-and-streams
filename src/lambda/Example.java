package lambda;

public class Example {

	public static void main(String[] args) {
		SampleInterface impl = (inputString) -> System.out.println(inputString);
		impl.printMe("Manchester United");
	}

}
