package com.alds.hr.gs;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		
		int[] data = new int[20];
		
		data[0] = 1;
		data[1] = 1;
		
		for(int i=2; i<20; i++) {
			data[i] = data[i-2] + data[i-1];
		}
		
		System.out.println(Arrays.toString(data));
	}
}
