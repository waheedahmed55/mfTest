package com.mftest.mftestread;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.mftest.mftestread.analyzers.Analyzer;
import com.mftest.mftestread.analyzers.AverageSiblingsAnalyzer;
import com.mftest.mftestread.analyzers.BirthMonthsAnalyzer;
import com.mftest.mftestread.analyzers.FavouriteFoodAnalyzer;
import com.mftest.mftestread.model.User;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	List<User> testUserSet = new ArrayList<User>();
	
	/**
	 * This is the test data setup 
	 */
	@Before 
	public void initialize() {
	       testUserSet.add(new User("LEONEL", "FERREL", "1", "Meatballs", "−01:00", "917172960000"));
	       testUserSet.add(new User("DELIA","MCCRAE","5","chicken","-08:00","601605300000"));
	       testUserSet.add(new User("EUGENE","VANDERSTEEN","2","Yogurt","+01:00","853371780000"));
	       testUserSet.add(new User("BERNARDINA","STWART","1","Mozzarella cheese","+10:30","285926100000"));
	       testUserSet.add(new User("BELINDA","BRIERE","1","Peanut Butter","-08:00","506741100000"));
	       testUserSet.add(new User("REUBEN","BUROKER","1","steak","-04:00","473775840000"));
	       testUserSet.add(new User("NUMBERS","KNAUB","3","ice cream","-09:00","189508980000"));
	       testUserSet.add(new User("CONCETTA","PALONE","1","grapes","+13:00","159790920000"));
	       testUserSet.add(new User("MORTON","SANTILLO","1","Corned beef","+01:00","832504840000"));
	       testUserSet.add(new User("SAMMIE","BARTELS","1","Ice Cream","-02:00","536484240000"));
	    }
	/**
	 * This is to test Avg Siblings Analyzer we are passing testUserSet to AverageSiblingAnalyzer
	 */
	@Test
    public void averageSiblingAnalyzerTest()
    {
    	Analyzer averageSiblingAnalyzer = new AverageSiblingsAnalyzer();
    	
    	String expectedOutput = "Average siblings: 1" + System.lineSeparator();
   
        assertEquals(expectedOutput, averageSiblingAnalyzer.analyze(testUserSet).getReport());
    }
    
	/**
	 * This is to test the top 3 faviourte food we are passing testuserset to FavouriteFoodAnalyzer
	 */
	@Test
    public void favouriteFoodAnalyzerTest()
    {
    	Analyzer favouriteFoodAnalyzer = new FavouriteFoodAnalyzer();
    	
    	String expectedOutput = "Favourite foods:" + System.lineSeparator()+
    	"- Ice Cream       1    "+ System.lineSeparator()+
    	"- chicken         1    "+ System.lineSeparator()+
    	"- Peanut Butter   1    "+ System.lineSeparator();

        assertEquals(expectedOutput, favouriteFoodAnalyzer.analyze(testUserSet).getReport());
    }
    
	/**
	 * This is to test birth month counts from by passing testuserset to BirthMonthsAnalzyer 
	 */
	@Test
    public void birthMonthAnalyzerTest()
    {
    	Analyzer birthMonthAnalyzerTest = new BirthMonthsAnalyzer();
    	
    	String expectedOutput = "Births per Month:"+System.lineSeparator()+
    			"- January    9    "+System.lineSeparator()+
    			"- February   0    "+System.lineSeparator()+
    			"- March      0    "+System.lineSeparator()+
    			"- April      0    "+System.lineSeparator()+
    			"- May        1    "+System.lineSeparator()+
    			"- June       0    "+System.lineSeparator()+
    			"- July       0    "+System.lineSeparator()+
    			"- August     0    "+System.lineSeparator()+
    			"- September  0    "+System.lineSeparator()+
    			"- October    0    "+System.lineSeparator()+
    			"- November   0    "+System.lineSeparator()+
    			"- December   0    "+System.lineSeparator();


        assertEquals(expectedOutput, birthMonthAnalyzerTest.analyze(testUserSet).getReport());
    }
}
