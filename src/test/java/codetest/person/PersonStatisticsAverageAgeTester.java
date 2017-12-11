package codetest.person;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import codetest.name.Name;
import junit.framework.Assert;

/**
 * Unit test for {@link PersonStatistics#calculateAverageAge(java.util.List)}.
 * 
 * @author brian
 */
public class PersonStatisticsAverageAgeTester {
	
	/**
	 * The person statistics.
	 */
	private PersonStatistics personStatistics;
	
	/**
	 * Sets up the statistics before each test.
	 */
	@Before
	public void setup() {
		this.personStatistics = new PersonStatistics();
	}

	/**
	 * Tests for a null list.
	 */
	@Test(expected = NullPointerException.class)
	public void forNullList() {
		List<Person> persons = null;
		
		this.personStatistics.calculateAverageAge(persons); // should throw a NullPointerException
	}
	
	/**
	 * Tests for an empty list.
	 */
	@Test
	public void forEmptyList() {
		List<Person> persons = new ArrayList<Person>();
		
		Assert.assertEquals("An empty list should have an average age of NaN", Double.NaN, this.personStatistics.calculateAverageAge(persons));
	}
	
	/**
	 * Tests for a list with a null age.
	 */
	@Test
	public void forListWithANullValue() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(new Name(), 20));
		persons.add(new Person(new Name(), 30));
		persons.add(new Person(new Name(), null));
		
		Assert.assertEquals("A null age should not contribute to the average", 25d, this.personStatistics.calculateAverageAge(persons));
	}
	
	/**
	 * Test for a list with no null ages.
	 */
	@Test
	public void forListWithNoNullValues() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(new Name(), 20));
		persons.add(new Person(new Name(), 30));
		persons.add(new Person(new Name(), 40));
		
		Assert.assertEquals("The average of 20, 30, and 40 should be 30", 30d, this.personStatistics.calculateAverageAge(persons));
	}
}
