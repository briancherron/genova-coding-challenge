package codetest.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import codetest.person.Person;
import codetest.person.PersonFileReader;
import codetest.person.PersonFileWriter;
import codetest.person.PersonPrinter;
import codetest.person.PersonStatistics;

/**
 * This class runs the codetest app.
 * 
 * @author brian
 */
public class App {
	
	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger(App.class);

	/**
	 * The main method for the app.
	 * 
	 * @param args the application arguments 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// first, read the two files
		PersonFileReader personFileReader = new PersonFileReader();
		List<Person> persons1 = null;
		List<Person> persons2 = null;
		try {
			 persons1 = personFileReader.readFile("NameList1.txt");
			 persons2 = personFileReader.readFile("NameList2.txt");
		} catch (FileNotFoundException e) {
			LOGGER.error("A file could not be found", e);
		} catch (IOException e) {
			LOGGER.error("An error occurred parsing a file",  e);
		}
		
		if (persons1 == null || persons2 == null) {
			System.out.println("One or more files could not be read. Please check the logs for more details.");
			System.exit(1);
		}
		
		// next, merge the two lists
		List<Person> allPersons = new ArrayList<Person>();
		allPersons.addAll(persons1);
		allPersons.addAll(persons2);
		
		// next, sort the lists by last name
		Collections.sort(allPersons);
		
		PersonStatistics personStatistics = new PersonStatistics();
		
		// next, count the number of duplicate first names
		int duplicateFirstNameCount = personStatistics.countDuplicateFirstName(allPersons);
		
		// next, calculate the average age for the combined lists
		double averageAge = personStatistics.calculateAverageAge(allPersons);
		
		// next, write the output to the console
		new PersonPrinter().print(allPersons, duplicateFirstNameCount, averageAge);
		
		// finally, write the output to a csv file
		new PersonFileWriter().writeFile(allPersons, duplicateFirstNameCount, averageAge);
	}
}
