package codetest.person;

import org.junit.Assert;
import org.junit.Test;

import codetest.name.Name;

/**
 * Unit tests for {@link Person} equality.
 * 
 * @author brian
 */
public class PersonEqualsTester {

	/**
	 * Tests equality against a null {@link Person}.
	 */
	@Test
	public void forNullOtherPerson() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Person person2 = null;
		
		Assert.assertFalse("A Person should not be equal to null", person1.equals(person2));
	}
	
	/**
	 * Tests equality against another object that is not an instance of {link Person}.
	 */
	@Test
	public void forOtherNotInstanceOfPerson() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Name person2 = new Name();
		
		Assert.assertFalse("An object that is not a Person should not be equal to a Person", person1.equals(person2));
	}
	
	/**
	 * Tests equality against a matching name only.
	 */
	@Test
	public void forMatchingNameOnly() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Person person2 = new Person(new Name("Jim", "James"), 42);
		
		Assert.assertFalse("A Person should not be equal to another Person if only the names match", person1.equals(person2));
	}
	
	/**
	 * Tests equality against a matching age only.
	 */
	@Test
	public void forMatchingAgeOnly() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Person person2 = new Person(new Name("Etta", "James"), 39);
		
		Assert.assertFalse("A Person should not be equal to another Person if only the names ages ", person1.equals(person2));
	}
	
	/**
	 * Tests equality against a matching name and age.
	 */
	@Test
	public void forMatchingNameAndAge() {
		Person person1 = new Person(new Name("Jim", "James"), 39);
		Person person2 = new Person(new Name("Jim", "James"), 39);
		
		Assert.assertTrue("A Person should be equal to another Person if the names and ages match", person1.equals(person2));
	}
}
