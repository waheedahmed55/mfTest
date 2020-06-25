package com.mftest.mftestread.analyzers;

import com.mftest.mftestread.model.User;
import java.util.*;

public class AverageSiblingsAnalyzer implements Analyzer {

	public AnalyticsReport analyze(List<User> users) {

		Integer totalSiblings = 0;
		
		// Get total number of siblings
		for(User user: users) {
			totalSiblings = totalSiblings + Integer.parseInt(user.getSiblings());
		}
		
		// Dividing total number of siblings by number of users in data set to get average
		int averageSiblings = totalSiblings / users.size();
		
		// Building report
		return new AnalyticsReport("Average siblings: " + averageSiblings + System.lineSeparator());
	}

}
