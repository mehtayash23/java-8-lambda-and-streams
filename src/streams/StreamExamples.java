package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void printCollection(List<String> names) {
		// Using lambda expression, given a name, print the name.
		names.forEach(name -> System.out.println(name));
		// Using method reference. Here reference is to println() which is an instance
		// method.
		names.forEach(System.out::println);
	}

	public static void toLowerCase(List<String> names) {
		// Here, String::toLowerCase is method reference to static method, and
		// System.out::println is method reference to instance method.
		names.stream().map(String::toLowerCase).forEach(System.out::println);
	}

	public static void joinNames(List<String> names) {
		// Old way to do this is..
		StringBuilder outputString = new StringBuilder("");
		for (int i = 0; i < names.size(); ++i) {
			outputString.append(names.get(i));
			if (i != names.size() - 1)
				outputString.append(" - ");
		}
		System.out.println(outputString.toString());

		// Using stream
		System.out.println(names.stream().collect(Collectors.joining(" - ")));
	}

	public static void filterNames(List<String> names) {
		// Filter the names having first character '4' and length of name > 4.
		names.stream().filter(name -> name.startsWith("R")).filter(name -> name.length() > 4)
				.forEach(System.out::println);

		// Filter the names with custom predicate.
		Predicate<String> predicate = ((name) -> name.startsWith("R") && name.length() > 4);
		names.stream().filter(predicate).forEach(System.out::println);

		// Filter the names and put the filtered names in a new list
		List<String> filteredNames = names.stream().filter(predicate).collect(Collectors.toList());
		filteredNames.forEach(System.out::println);
	}

	public static void findFirstName(List<String> names) {
		// There is no guarantee that there exists a name which starts with 'R', so it
		// gives the optional type output.
		Optional<String> firstName = names.stream().filter(name -> name.startsWith("R")).findFirst();
		firstName.orElse("No name found");
		firstName.ifPresent(System.out::println);
	}

	public static void totalCharacters(List<String> names) {
		// Using reduce function.
		int totalCharacters = names.stream().mapToInt(name -> name.length()).reduce(0, (sum, length) -> sum += length);
		System.out.println(totalCharacters);

		// Using sum().
		totalCharacters = names.stream().mapToInt(name -> name.length()).sum();
		System.out.println(totalCharacters);
	}

	public static void printEachNameCount(List<String> names) {
		names.stream().mapToInt(name -> name.length()).forEach(System.out::println);

		// By creating a function.
		Function<String, Integer> function = name -> name.length();
		names.stream().map(function).forEach(System.out::println);
	}

	public static void sortTheList(List<String> names) {
		// Comparator to sort the list.
		Comparator<String> comparator = (name1, name2) -> {
			return (name1.compareTo(name2)) >= 0 ? 0 : -1;
		};
		List<String> sortedNames = names.stream().sorted(comparator).collect(Collectors.toList());
		sortedNames.forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Joey", "Chandler", "Monica", "Phoebe", "Ross", "Rachel");
		System.out.println("Print the list");
		printCollection(names);

		System.out.println("In lower case...");
		toLowerCase(names);

		System.out.println("Join names with ,");
		joinNames(names);

		System.out.println("Filter the list...");
		filterNames(names);

		System.out.println("Find first person from the list...");
		findFirstName(names);

		System.out.println("Total characters in the list...");
		totalCharacters(names);

		System.out.println("Total characters in each name...");
		printEachNameCount(names);

		System.out.println("Sort the list...");
		sortTheList(names);
	}
}
