package codetest.person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

/**
 * Reads files containing {@link Person} information.
 * 
 * @author brian
 */
public class PersonFileReader {

	/**
	 * Reads a file for {@link {Person} information.
	 * 
	 * @param fileName the file name
	 * @return a list of persons, or an empty list if no persons are read
	 * @throws FileNotFoundException if a file is not found with the specified name
	 * @throws IOException if an error occurs parsing the file
	 */
	public List<Person> readFile(String fileName) throws FileNotFoundException, IOException {
		List<Person> persons = new ArrayList<Person>();
		Reader reader = new FileReader(this.getClass().getClassLoader().getResource(fileName).getFile());
		Iterable<CSVRecord> records = CSVFormat.TDF.withFirstRecordAsHeader().parse(reader);
		for (CSVRecord record : records) {
			Person person = new Person();
			person.getName().setFirst(record.get("First Name").trim());
			person.getName().setLast(record.get("Last Name").trim());
			person.setAge(StringUtils.isNotBlank(record.get("Age").trim()) && StringUtils.isNumeric(record.get("Age").trim()) 
				? Integer.valueOf(record.get("Age").trim())
				: null);
			
			persons.add(person);
		}
		reader.close();
		
		return persons;
	}
}
