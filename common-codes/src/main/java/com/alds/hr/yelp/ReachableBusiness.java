package com.alds.hr.yelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author rohsingh
 * 
 * 
 * 
		a
		3
		a b 2
		a c 4
		b d 5

		b
 *
 */

public class ReachableBusiness {

	class Business {
		/**
		 * The name of the business.
		 */
		String name;

		/**
		 * A Map of nearbyBusinesses where the key is the nearby Business object and the
		 * value is distance from the current Business to the nearby Business.
		 */
		Map<Business, Integer> nearbyBusinesses;

		public Business(String name) {
			this.name = name;
			this.nearbyBusinesses = new HashMap<Business, Integer>();
		}

		public String getName() {
			return this.name;
		}

		public Map<Business, Integer> getNearbyBusinesses() {
			return this.nearbyBusinesses;
		}
	}

	private static List<String> answer = new ArrayList<>();
	private static Map<Business, Boolean> visited = new HashMap<>();

	public static List<String> findReachableBusinesses(Business startingBusiness, int distance) {
		visited.put(startingBusiness, true);
		search(startingBusiness, distance, 0);
		return answer;
	}

	public static void search(Business startingBusiness, int distance, int curr) {
		Map<Business, Integer> near = startingBusiness.getNearbyBusinesses();
		for (Business b : near.keySet()) {
			if (Boolean.FALSE.equals(visited.getOrDefault(b, false)) && near.get(b) + curr <= distance) {
				visited.put(b, true);
				answer.add(b.getName());
				search(b, distance, curr + near.get(b));
			}
		}
	}
}
