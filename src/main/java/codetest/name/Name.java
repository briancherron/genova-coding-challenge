package codetest.name;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Represents a name.
 * 
 * @author brian
 */
public class Name implements Comparable<Name> {

	/**
	 * The first name.
	 */
	private String first;
	
	/**
	 * The last name.
	 */
	private String last;
	
	/**
	 * No-arg constructor.
	 */
	public Name() {
		// no-arg constructor
	}
	
	/**
	 * Constructor initializes fields.
	 * 
	 * @param first the first name
	 * @param last the last name
	 */
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	/**
	 * Compares to another name. Comparison is made by {@link #last} name, then {@link #first} name.
	 */
	public int compareTo(Name otherName) {
		if (otherName == null) {
			return 1;
		}
		
		if (StringUtils.equals(this.last, otherName.last)) {
			if (StringUtils.equals(this.first, otherName.first)) {
				return 0;
			} else {
				return this.first.compareTo(otherName.first);
			}
		} else {
			return this.last.compareTo(otherName.last);
		}
	}
	
	/**
	 * Test equality against another objects. Considered equal if the other object is a {@link Name} and both the
	 * {@link #first} name and {@link #last} name match.
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Name) {
			return StringUtils.equals(this.first, ((Name) o).first)
				&& StringUtils.equals(this.last, ((Name) o).last);
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
	 * @return the first
	 */
	public String getFirst() {
		return this.first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return this.last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}
}
