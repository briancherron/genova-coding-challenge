package codetest.name;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Unit tests for {@link Name} comparison.
 * 
 * @author brian
 */
public class NameCompareToTester {

	/**
	 * Tests comparison against a null other {@link Name}.
	 */
	@Test
	public void forNullOtherName() {
		Name name1 = new Name("Jim", "James");
		Name name2 = null;
		
		Assert.assertEquals("A non-null name should return 1 when compared to a null name", 1, name1.compareTo(name2));
	}
	
	/**
	 * Tests comparison against a matching first and last name.
	 */
	@Test
	public void forMatchingFirstAndLastName() {
		Name name1 = new Name("Jim", "James");
		Name name2 = new Name("Jim", "James");
		
		Assert.assertEquals("Matching names should return 0", 0, name1.compareTo(name2));
	}
	
	/**
	 * Tests comparison against a matching last name a non-matching first name.
	 */
	@Test
	public void forNonMatchingFirstName() {
		Name name1 = new Name("Jim", "James");
		Name name2 = new Name("Etta", "James");
		
		Assert.assertTrue("Non-matching first name should not return 0", name1.compareTo(name2) != 0);
	}
	
	/**
	 * Tests comparison against a non-matching last name and matching first name.
	 */
	@Test
	public void forNonMatchingLastName() {
		Name name1 = new Name("Jim", "James");
		Name name2 = new Name("Jim", "Morrison");
		
		Assert.assertTrue("Non-matching last name should not return 0", name1.compareTo(name2) != 0);
	}
}
