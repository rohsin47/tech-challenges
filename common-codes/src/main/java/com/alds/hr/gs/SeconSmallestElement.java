package com.alds.hr.gs;

import java.util.stream.IntStream;

public class SeconSmallestElement {
	
	public static int shortest(int[] input) {	
		int shortest = 0;
		int pivot = input[0];
		if(input != null) {
			for(int i=1; i<input.length; i++) {
				if(input[i] < pivot) {
					shortest = i;
					pivot = input[i];
				}
			}
		}
		return shortest;
	}

	public static int findnthShortest(int n, int[] input) {
		int finalResult = 0;
		//for(int i =0; i<n; i++ ) {
			int result = shortest(input);
			int[] newArray = IntStream.range(0, input.length)
					.filter(j -> j!= result)
					.map(j -> input[j])
					.toArray();
			 finalResult = newArray[shortest(newArray)];
		//}
		return finalResult;
	}
	
	
	public static void main(String[] args) {
		System.out.println(findnthShortest(1, new int[] {2, 3, 5, 4, 1, 6}));
	}
}

