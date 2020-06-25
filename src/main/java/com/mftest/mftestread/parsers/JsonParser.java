package com.mftest.mftestread.parsers;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mftest.mftestread.exceptions.FileParseException;
import com.mftest.mftestread.model.*;
import java.util.*;

public class JsonParser implements FileParser {

	public List<User> parse(File file) throws FileParseException {

		ObjectMapper mapper = new ObjectMapper();

		List<User> users = new ArrayList<User>();
		try {
			users = Arrays.asList(mapper.readValue(file, User[].class));
		} catch (JsonParseException e) {
			throw new FileParseException("Error reading file: " + e.getMessage());
		} catch (JsonMappingException e) {
			throw new FileParseException("Error reading file: " + e.getMessage());
		} catch (IOException e) {
			throw new FileParseException("Error reading file: " + e.getMessage());
		}
		
		return users;
		
	}

}
