package com.mftest.mftestread.analyzers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mftest.mftestread.model.User;

public class FavouriteFoodAnalyzer implements Analyzer {

	public AnalyticsReport analyze(List<User> users) {		
		// Hasmap to store count of each occurence of particular favorite food.
		HashMap<String, Integer> favoriteFoods = new HashMap<String, Integer>();
		
		// Initializing the report
		StringBuilder report = new StringBuilder();
		report.append("Favourite foods:");
		report.append(System.lineSeparator());
		
		// Get counts of all foods
		for(User user: users) {
			
			String favoriteFood = user.getFavourite_food();
			Integer favoriteFoodCount = favoriteFoods.get(favoriteFood);
			
			
			if(favoriteFoodCount != null) {
				// If food exists, increment the count
				favoriteFoods.put(favoriteFood, favoriteFoodCount+1);
			} else {
				// If food doesn't exist, initialize with 1
				favoriteFoods.put(favoriteFood, 1);
			}
		}
		

		// Convert counts map to a list to sort
	    List<Entry<String, Integer>> favouriteFoodList = new ArrayList<Entry<String, Integer>>(
	    		favoriteFoods.entrySet());

	    // Sort based on the count
	    Collections.sort(favouriteFoodList, new Comparator<Map.Entry<String, Integer>>() {

	        public int compare(Entry<String, Integer> o1,
	                Entry<String, Integer> o2) {

	            return o2.getValue().compareTo(o1.getValue());
	        }

	    });
	    
	    // Choose top three
	    List<Entry<String, Integer>> topThreeFoods = favouriteFoodList.subList(0, 3);
	    
	    // Generate the report
	    for(Entry<String, Integer> favouriteFood : topThreeFoods) {
		    report.append(String.format( "- %-15s %-5s%n", favouriteFood.getKey(), favouriteFood.getValue().toString() ));
	    }
	   		
		return new AnalyticsReport(report.toString());
	}
}
