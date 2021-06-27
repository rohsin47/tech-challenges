package com.alds.hr.commerzbank;

import java.util.Arrays;

public class TestArrayRotation {
	
	public static void main(String[] args){
		int[] input = {1,2,3,4,5};	
		rightShiftByN(input, 3);
		System.out.println(Arrays.toString(input));
	}
	
	public static void rightShiftByN(int[] input, int N){
		for(int i=1; i <= N; i++){
			rightShift(input);
		}
	}
	
	public static void rightShift(int[] input) {
		int temp = input[input.length - 1];
		for(int i = input.length-1; i > 0; i--){
			input[i] = input[i-1];
		}
		input[0] = temp;

	}

}
