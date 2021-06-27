package com.alds.hr.gs;

import java.util.HashMap;
import java.util.Map;

public class FindingPairs {
	
	public static int findPairs(int sum, int[] data) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<data.length; i++) {
			if(!map.containsKey(data[i])) {
				map.put(data[i], 1);
			} else {
				map.put(data[i], map.get(data[i]) + 1);
			}
		}
		
		int count = 0;
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(sum - data[i])) {
				count +=1;
			}
		}
		return count/2;
	}
	
	public static void main(String[] args) {
		System.out.println("Pairs : "+findPairs(12, new int[] {1, 5, 7, 9, 6, 3, 6}));
	}

}
