package com.alds.local.cyclicSort;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rohsi
 * 
 * 
 * ou are given an unsorted array with both positive and negative elements. You have to find 
 * the smallest positive number missing from the array in O(n) time using constant extra space. 
 * You can modify the original array.
 
 	Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 	Output: 4
 *
 */
public class MissingSmallestPositiveNumber {
	
	// hashing way (O(n) and O(n))
	public static int findMin(int[] arr) {
		int n = arr.length;
		int min = 0;
		boolean first = false;
		int res = 0;
		Set<Integer> data = new HashSet<Integer>();
		for(int i=0; i<n; i++){
			if(arr[i] > 0) {
				data.add(arr[i]);
				if(!first) {
					min = arr[i];
					first = true;
				}
				if(min > arr[i]) {
					min = arr[i];
				}
			}
		}
		
		int j=0;
		if(min > 1) {
			return 1;
		}
		while(j < data.size()) {
			min++;
			if(!data.contains(min)) {
				res = min;
				break;
			}
			j++;
		}
		return res;
	}
	
	// time - O(n) space - O(1)
	public static int findMissingE(int[] arr) {
		int n = arr.length;
		// segregate first via two pointer approach
		int j=0;
		for(int i=0; i<n; i++) {
			if(arr[i] <= 0) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
			
		}
		
		// +ve array only
		int k=0;
		int[] arr2 = new int[n-j];
		for(int i=j; i<n; i++) {
			arr2[k] = arr[i]; 
			k++;
		}
		
		// Mark arr[i] as visited by making 
        // arr[arr[i] - 1] negative. Note that 
        // 1 is subtracted because index start 
        // from 0 and positive numbers start from 1 
		// this is done so as it will mark all the 
		// element which are present as negative and 
		// missing one will be  left as index will not
		// be found and set negative
		for(int i=0; i<arr2.length; i++) {
			int x = Math.abs(arr2[i]);
			if(x-1 < arr2.length) {
				arr2[x-1] = -arr2[x-1];
			}
		}
		
		for(int i=0; i<arr2.length; i++) {
			if(arr2[i] > 0) {
				return i+1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
        int[] test ={ 2, 3, -7, 6, 8, 1, -10, 15 };
        System.out.println("Missing number : "+findMissingE(test));
    }

}
