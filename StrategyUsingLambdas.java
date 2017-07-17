import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate; // functional interface takes object returns bool

class Util {

	// normal function -> can take objects and return objects
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}
}

public class StrategyUsingLambdas {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// total all values

		System.out.println(totalValues(numbers, e -> true)); // using lambdas
		System.out.println(totalValues(numbers, Util::isEven)); // using function reference
		System.out.println(totalValues(numbers, e -> e % 2 != 0));
	}

	// high order function takes function as parameter and can return function
	public static int totalValues(List<Integer> values, Predicate<Integer> selector) {

		/*
		 * imperative style (this is actually spaghetti code):
		 * 
		 * int total = 0;
		 * 
		 * for(int e: values) if(selector.test(e)) total += e;
		 * 
		 * return total;
		 */

		/*
		 * functional style
		 * 
		 * return values.stream() .filter(selector) .mapToInt(e -> e) .sum();
		 */

		// ... or using function reference
		return values.stream().filter(selector).reduce(0, Integer::sum);

	}

}
