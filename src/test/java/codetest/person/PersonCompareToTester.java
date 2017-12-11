package codetest.person;

import org.junit.Test;

import codetest.name.Name;
import junit.framework.Assert;

/**
 * Unit tests for {@link Person} comparison.
 * 
 * @author brian
 */
public class PersonCompareToTester {

	@Test
	public void forNullOtherPerson() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Person person2 = null;
		
		Assert.assertEquals("A non-null person should return 1 when compared to a null name", 1, person1.compareTo(person2));
	}
	
	@Test
	public void forMatchingNameAndAge() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Person person2 = new Person(new Name("Jim", "James"), 39);
		
		Assert.assertEquals("Matching persons should return 0", 0, person1.compareTo(person2));
	}
	
	@Test
	public void forMatchingNameOnly() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Person person2 = new Person(new Name("Jim", "James"), 42);
		
		Assert.assertTrue("Persons with non-matching ages should not return 0", person1.compareTo(person2) != 0);
	}
	
	@Test
	public void forMatchingAgeOnly() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Person person2 = new Person(new Name("Etta", "James"), 74);
		
		Assert.assertTrue("Persons with non-matching names should not return 0", person1.compareTo(person2) != 0);
	}
}
