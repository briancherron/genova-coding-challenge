package codetest.person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

/**
 * Writes files containing {@link Person} information.
 * 
 * @author brian
 */
public class PersonFileWriter {

	/**
	 * Writes out a person file containing a sorted list of persons, the duplicate first name count, and average age.
	 * 
	 * @param persons the persons
	 * @param duplicateFirstNameCount the number of duplicated first names
	 * @param averageAge the average age
	 * @throws IOException if an error occurs writing the file
	 */
	public void writeFile(List<Person> persons, int duplicateFirstNameCount, double averageAge) throws IOException {
		CSVPrinter printer = new CSVPrinter(
			new  FileWriter("output.csv"), 
			CSVFormat.DEFAULT.withHeader("Lastname", "Firstname", "age").withQuoteMode(QuoteMode.ALL));
		for (Person person : persons) {
			printer.printRecord(person.getName().getLast(), person.getName().getFirst(), person.getAge());
		}
		
		printer.printRecord("There were " + duplicateFirstNameCount + " incidences of duplicate first names");
		printer.printRecord("The average age for both files was " + averageAge);
		printer.flush();
		printer.close();
	}
}
