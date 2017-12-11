package codetest.person;

import java.util.List;

/**
 * Prints out {@link Person} information.
 * 
 * @author brian
 */
public class PersonPrinter {

	/**
	 * Prints a sorted list of persons, the duplicate first name count, and average age.
	 * 
	 * @param persons the persons
	 * @param duplicateFirstNameCount the number of duplicated first names
	 * @param averageAge the average age
	 */
	public void print(List<Person> persons, int duplicateFirstNameCount, double averageAge) {
		System.out.println("Lastname,FirstName,Age");
		for (Person person : persons) {
			System.out.println(person.getName().getLast() + "," + person.getName().getFirst() + "," + person.getAge());
		}
		System.out.println("There were " + duplicateFirstNameCount + " incidences of duplicate first names");
		System.out.println("The average age for both files was " + averageAge);
	}
}
