package codetest.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Performs basic statistical calculations for {@link Person}.
 * 
 * @author brian
 */
public class PersonStatistics {

	/**
	 * Counts the number of first names that are duplicated in a list of {@link Person}.
	 * 
	 * @param persons the persons
	 * @return the number of duplicated first names
	 */
	public int countDuplicateFirstName(List<Person> persons) {
		Map<String, Integer> firstNameOccurrenceMap = new HashMap<String, Integer>();
		for (Person person : persons) {
			if (!firstNameOccurrenceMap.containsKey(person.getName().getFirst())) {
				firstNameOccurrenceMap.put(person.getName().getFirst(), 0);
			}
			
			firstNameOccurrenceMap.put(person.getName().getFirst(), firstNameOccurrenceMap.get(person.getName().getFirst()) + 1);
		}
		
		int countOfDuplicateFirstNames = 0;
		for (Integer count : firstNameOccurrenceMap.values()) {
			if (count > 1) {
				countOfDuplicateFirstNames++;
			}
		}
		
		return countOfDuplicateFirstNames;
	}
	
	/**
	 * Calculates the average age in a list of {@link Person}.
	 * 
	 * @param persons the persons
	 * @return the average age
	 */
	public double calculateAverageAge(List<Person> persons) {
		DescriptiveStatistics stats = new DescriptiveStatistics();
		for (Person person : persons) {
			if (person.getAge() != null) {
				stats.addValue(person.getAge());
			}
		}
		
		return stats.getMean();
	}
}
