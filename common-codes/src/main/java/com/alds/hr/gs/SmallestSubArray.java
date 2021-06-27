package com.alds.hr.gs;

public class SmallestSubArray {

	public static int smallestSubArray(int[] input, int x) {

		int n = input.length + 1;
		int sum = 0;
		int result = 0;

		for (int i = 0; i < input.length; i++) {

			sum = input[i];

			for (int j = i + 1; j < input.length; j++) {

				sum = sum + input[j];

				if (sum > x && (j - i)< n) {
					result = j - i;
				}
			}

		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(smallestSubArray(new int[] {1, 4, 45, 6, 0, 19}, 51));
	}

}
