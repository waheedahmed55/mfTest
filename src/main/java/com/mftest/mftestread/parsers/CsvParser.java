package com.mftest.mftestread.parsers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.mftest.mftestread.exceptions.FileParseException;
import com.mftest.mftestread.model.*;

public class CsvParser implements FileParser {

	public List<User> parse(File file) throws FileParseException {
		try {
			Reader reader = new FileReader(file);
			// Inititalizing the CSV Parsing utility and passing it the CSV file
			CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
			// Going through each CSVRecord, and adding it list of users
			List<User> userRecords = new ArrayList<User>();

			for (CSVRecord csvRecord : csvParser.getRecords()) {
				userRecords.add(new User(csvRecord.get("first_name"), csvRecord.get("last_name"),
						csvRecord.get("siblings"), csvRecord.get("favourite_food"), csvRecord.get("birth_timezone"),
						csvRecord.get("birth_timestamp")));
			}

			return userRecords;
		} catch (IOException ex) {
			throw new FileParseException("Error reading file: " + ex.getMessage());
		}
	}

}
