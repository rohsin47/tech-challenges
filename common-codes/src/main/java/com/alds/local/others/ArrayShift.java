package com.alds.local.others;

import java.util.Arrays;

/**
 * @author rohsi
 * 
 * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2
 * Output : arr[] = [3, 4, 5, 6, 7, 1, 2]
 *
 */
public class ArrayShift {

	public static int[] shiftArrayB(int[] arr) {
		int n = arr.length;
		int[] copy = new int[n];
	
		copy[0] = arr[n-1];
		
		for(int i=0; i<n-1; i++) {
			copy[i+1] = arr[i];
		}
		return copy;
	}
	
	public static int[] shiftArrayE(int[] arr) {
		int n = arr.length;	
		int last = arr[n-1];		
		for(int i=0; i<n-1; i++) {
			arr[n-1-i] = arr[n-2-i];
		}	
		arr[0] = last;
		return arr;
	}

    public static void main(String[] args) {
    	int[] test = {1, 2, 3, 4, 5, 6, 7};
    	System.out.println("Result : "+Arrays.toString(shiftArrayE(test)));
    }
}
