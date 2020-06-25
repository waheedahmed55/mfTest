package com.mftest.mftestread;

import java.io.File;
import java.util.List;

import com.mftest.mftestread.analyzers.AverageSiblingsAnalyzer;
import com.mftest.mftestread.analyzers.BirthMonthsAnalyzer;
import com.mftest.mftestread.analyzers.FavouriteFoodAnalyzer;
import com.mftest.mftestread.analyzers.Analyzer;
import com.mftest.mftestread.exceptions.FileParseException;
import com.mftest.mftestread.model.User;
import com.mftest.mftestread.parsers.*;
/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
    	if(args.length != 1) {
    		System.out.println("Expected one argument for the file path");
    	}
        String filename = args[0];
        
        FileParser fileParser = getParser(filename);
        Analyzer averageSiblings = new AverageSiblingsAnalyzer();
        Analyzer favoriteFoods = new FavouriteFoodAnalyzer();
        Analyzer birthsPerMonth = new BirthMonthsAnalyzer();

        
        try {
			List<User> users = fileParser.parse(new File(filename));
			System.out.println(averageSiblings.analyze(users).getReport());
			System.out.println(favoriteFoods.analyze(users).getReport());
			System.out.println(birthsPerMonth.analyze(users).getReport());
			
		} catch (FileParseException e) {
			e.printStackTrace();
		}
    }
    
	private static FileParser getParser(String filename) {
		if (filename.endsWith(".csv")) {
			return new CsvParser();
		} else if (filename.endsWith(".json")) {
			return new JsonParser();
		} else {
			throw new IllegalArgumentException("Invalid File extension");
		}
	}
	
}
