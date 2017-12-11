package codetest.person;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import codetest.name.Name;
import junit.framework.Assert;

/**
 * Unit tests for {@link PersonStatistics#countDuplicateFirstName(java.util.List)}.
 * 
 * @author brian
 *
 */
public class PersonStatisticsDuplicateFirstNameCountTester {

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
		
		this.personStatistics.countDuplicateFirstName(persons); // should throw a NullPointerException
	}
	
	/**
	 * Tests for an empty list.
	 */
	@Test
	public void forEmptyList() {
		List<Person> persons = new ArrayList<Person>();
		
		Assert.assertEquals("An empty list should have no duplicate first names", 0, this.personStatistics.countDuplicateFirstName(persons));
	}
	
	/**
	 * Tests for a list with a first name duplicated once.
	 */
	@Test
	public void forFirstNameDuplicatedOnce() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(new Name("Jim", "James"), 39));
		persons.add(new Person(new Name("Jim", "Morrison"), 27));
		persons.add(new Person(new Name("Etta", "James"), 74));
		
		Assert.assertEquals("Two names each duplicate once should return 1", 1, this.personStatistics.countDuplicateFirstName(persons));
	}
	
	/**
	 * Tests for a list with a first name duplicated twice.
	 */
	@Test
	public void forFirstNameDuplicatedTwice() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(new Name("Jim", "James"), 39));
		persons.add(new Person(new Name("Jim", "Morrison"), 27));
		persons.add(new Person(new Name("Jim", "Croce"), 30));
		persons.add(new Person(new Name("Etta", "James"), 74));
		
		Assert.assertEquals("Two names each duplicate twice should return 2", 1, this.personStatistics.countDuplicateFirstName(persons));
	}
}
