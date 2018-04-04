package streams;

/*
 * Give a list of integers, find the sum of even numbers.
 */

import java.util.Arrays;
import java.util.List;

public class ParallelStream {

	public static void withoutParallelStream(List<Integer> numbers) {
		int totalSum = numbers.stream().filter(e -> e % 2 == 0).mapToInt(ParallelStream::compute).sum();
		System.out.println(totalSum);
	}

	public static void withParallelStream(List<Integer> numbers) {
		int totalSum = numbers.parallelStream().filter(e -> e % 2 == 0).mapToInt(ParallelStream::compute).sum();
		System.out.println(totalSum);
	}

	public static int compute(int value) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		return value;
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		long startTime = System.currentTimeMillis();
		withoutParallelStream(numbers);
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time without parallelStream: " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		withParallelStream(numbers);
		endTime = System.currentTimeMillis();
		System.out.println("Execution time with parallelStream: " + (endTime - startTime));
	}
}
