package codetest.name;

import org.junit.Assert;
import org.junit.Test;

import codetest.person.Person;

/**
 * Unit tests for {@link Name} equality.
 * 
 * @author brian
 */
public class NameEqualsTester {

	/**
	 * Tests equality against a null {@link Name}.
	 */
	@Test
	public void forNullOtherName() {
		Name name1 = new Name("Jim", "James");
		Name name2 = null;
		
		Assert.assertFalse("A Name should not be equal to null", name1.equals(name2));
	}
	
	/**
	 * Tests equality against another object that is not an instance of {link Name}.
	 */
	@Test
	public void forOtherNotInstanceOfName() {
		Name name1 = new Name("Jim", "James");
		Person name2 = new Person();
		
		Assert.assertFalse("An object that is not a Name should not be equal to a Name", name1.equals(name2));
	}
	
	/**
	 * Tests equality against a matching first name only.
	 */
	@Test
	public void forMatchingFirstNameOnly() {
		Name name1 = new Name("Jim", "James");
		Name name2 = new Name("Jim", "Morrison");
		
		Assert.assertFalse("A Name should not be equal to another Name if only the first names match", name1.equals(name2));
	}
	
	/**
	 * Tests equality against a matching last name only.
	 */
	@Test
	public void forMatchingLastNameOnly() {
		Name name1 = new Name("Jim", "James");
		Name name2 = new Name("Etta", "James");
		
		Assert.assertFalse("A Name should not be equal to another Name if only the last names match", name1.equals(name2));
	}
	
	/**
	 * Tests equality against a matching first and last name.
	 */
	@Test
	public void forMatchingFirstAndLastName() {
		Name name1 = new Name("Jim", "James");
		Name name2 = new Name("Jim", "James");
		
		Assert.assertTrue("A Name should be equal to another Name if both first and last names match", name1.equals(name2));
		
	}
}
