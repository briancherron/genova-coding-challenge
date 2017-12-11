package codetest.person;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import codetest.name.Name;

/**
 * Represents a person.
 * 
 * @author brian
 */
public class Person implements Comparable<Person> {

	/**
	 * The person's name.
	 */
	private final Name name;
	
	/**
	 * The person's age.
	 * <p>
	 * Object instead of primitive in case a null value is encountered.
	 */
	private Integer age;
	
	/**
	 * No-arg constructor.
	 */
	public Person() {
		this.name = new Name();
	}
	
	/**
	 * Constructor initializes fields.
	 * 
	 * @param name the name
	 * @param age the age
	 */
	public Person(Name name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Compares to another person. Comparison is made by last name, then first name, then age.
	 */
	public int compareTo(Person otherPerson) {
		if (otherPerson == null) {
			return 1;
		} 
		
		if (this.name.equals(otherPerson.name)) {
			if ((this.age == null && otherPerson.age == null) 
				|| (this.age == otherPerson.age)) {
				
				return 0;
			} else {
				return this.age.compareTo(otherPerson.age);
			}
		} else {
			return this.name.compareTo(otherPerson.name);
		}
	}
	
	/**
	 * Test equality against another objects. Considered equal if the other object is a {@link Person} and both the
	 * {@link #name} and {@link #age} match.
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Person) {
			return ((this.name == null && ((Person) o).name == null) || this.name.equals(((Person) o).name))
				&& ((this.age == null && ((Person) o).age == null) || this.age.equals(((Person) o).age));
		}
		
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return this.name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return this.age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
}
