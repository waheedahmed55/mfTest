package com.mftest.mftestread.analyzers;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import com.mftest.mftestread.model.User;

public class BirthMonthsAnalyzer implements Analyzer {

	public AnalyticsReport analyze(List<User> users) {		
		// Hasmap to store count of total births per month
		HashMap<Integer, Integer> monthBirthCountMap = new HashMap<Integer, Integer>();
		
		// Initializing the report
		StringBuilder report = new StringBuilder();
		report.append("Births per Month:");
		report.append(System.lineSeparator());
		
		// Get birth counts per month
		for(User user: users) {
			
			// Get Calendar instance based on birth timezone and birth time
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"+user.getBirth_timezone()));
			calendar.setTimeInMillis(Long.parseLong(user.getBirth_timestamp()));
			
			Integer month = calendar.get(Calendar.MONTH);
			Integer birthCount = monthBirthCountMap.get(month);			
			
			if(birthCount != null) {
				// If month exists, increment the count
				monthBirthCountMap.put(month, birthCount+1);
			} else {
				// If month doesn't exist, initialize with 1
				monthBirthCountMap.put(month, 1);
			}
		}
		
		
		for(int i=0; i<12; i++) {
			// Prepare report for each month using the hashmap
			Integer monthCount = monthBirthCountMap.get(i);
			// Convert month index to string
			String monthString = new DateFormatSymbols().getMonths()[i];
			
			if(monthCount == null) {
				monthCount = 0;
			}
		    report.append(String.format( "- %-10s %-5s%n", monthString, monthCount));
		}

		return new AnalyticsReport(report.toString());
	}
}
