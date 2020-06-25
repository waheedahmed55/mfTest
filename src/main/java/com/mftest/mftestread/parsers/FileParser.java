package com.mftest.mftestread.parsers;

import com.mftest.mftestread.exceptions.FileParseException;
import com.mftest.mftestread.model.*;
import java.io.*;
import java.util.List;
public interface FileParser {

	public List<User> parse(File file) throws FileParseException;
}
