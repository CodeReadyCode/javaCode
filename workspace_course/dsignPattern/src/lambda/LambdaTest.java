package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaTest {

	public static void main(String[] args) {
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");

			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);
			
			////////////////////////////////
			
			Arrays.asList("a1", "a2", "a3")
		    .stream()
		    .findFirst()
		    .ifPresent(System.out::println);  // a1
			
			////////////////////////////////
			
			Stream.of("a1", "a2", "a3")
		    .map(s -> s.substring(1))
		    .mapToInt(Integer::parseInt)
		    .max()
		    .ifPresent(System.out::println);  // 3
			
			/////////////////////////////////
			
			List<Person> persons =	
				    Arrays.asList(
				        new Person("Max", 18),
				        new Person("Peter", 23),
				        new Person("Pamela", 23),
				        new Person("David", 12));
			
			List<Person> filtered =
				    persons
				        .stream()
				        .filter(p -> p.name.startsWith("P"))
				        .collect(Collectors.toList());

				System.out.println(filtered);    // [Peter, Pamela]

				
				//////////////////////////////////////
				
				
				Map<Integer, String> map = persons
					    .stream()
					    .collect(Collectors.toMap(
					        p -> p.age,
					        p -> p.name,
					        (name1, name2) -> name1 + ";" + name2));

					System.out.println(map);
					// {18=Max, 23=Peter;Pamela, 12=David}
				
				
				Map<Integer, List<Person>> personsByAge = persons
					    .stream()
					    .collect(Collectors.groupingBy(p -> p.age));

					personsByAge
					    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
					
					///////////////////////////
					
			    IntSummaryStatistics ageSummary =
						    persons
						        .stream()
						        .collect(Collectors.summarizingInt(p -> p.age));

			System.out.println(ageSummary);
			// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
					
			///////////////////////////
			
			
			List<Foo> foos = new ArrayList<>();

			// create foos
			IntStream
			    .range(1, 4)
			    .forEach(i -> foos.add(new Foo("Foo" + i)));

			// create bars
			foos.forEach(f ->
			    IntStream
			        .range(1, 4)
			        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
			
			
			/////////////////////////
			
			
			
			foos.stream()
		    .flatMap(f -> f.bars.stream())
		    .forEach(b -> System.out.println(b.name));

		// Bar1 <- Foo1
		// Bar2 <- Foo1
		// Bar3 <- Foo1
		// Bar1 <- Foo2
		// Bar2 <- Foo2
		// Bar3 <- Foo2
		// Bar1 <- Foo3
		// Bar2 <- Foo3
		// Bar3 <- Foo3
			
			/////////////////////
			
			persons
		    .stream()
		    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
		    .ifPresent(System.out::println);    // Pamela
		
			
			////////////////////////
			
			Person result =
				    persons
				        .stream()
				        .reduce(new Person("", 0), (p1, p2) -> {
				            p1.age += p2.age;
				            p1.name += p2.name;
				            return p1;
				        });

				System.out.format("name=%s; age=%s", result.name, result.age);
				// name=MaxPeterPamelaDavid; age=76
				
		//////////////////////////////
				
				Integer ageSum = persons
					    .stream()
					    .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

					System.out.println(ageSum);  // 76
			
	}

}
