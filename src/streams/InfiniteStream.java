package streams;

import java.util.stream.Stream;

/*
 * Given a number k, and a count n, 
 * find the sum of cube of n odd integers starting with k, where square root of each number is > 25 
 */

public class InfiniteStream {

	public static void withoudInfiniteStream(int k, int n) {
		int totalSum = 0;
		int count = 0;
		int value = k;
		while (count < n) {
			if (value % 2 == 1 && Math.sqrt(value) > 25) {
				totalSum += Math.pow(value, 3);
				// System.out.println(value);
				count++;
			}
			value++;
		}
		System.out.println(totalSum);
	}

	public static void withInfiniteStream(int k, int n) {
		int totalSum = Stream.iterate(k, value -> value + 1).filter(value -> value % 2 == 1)
				.filter(value -> Math.sqrt(value) > 25).mapToInt(value -> (int) Math.pow(value, 3)).limit(n).sum();
		System.out.println(totalSum);
	}

	public static void main(String[] args) {
		withoudInfiniteStream(1, 2);
		withInfiniteStream(1, 2);
	}

}
