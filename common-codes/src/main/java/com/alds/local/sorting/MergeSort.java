package com.alds.local.sorting;

import java.util.Arrays;

/**
 * @author rohsi
 *
 */
public class MergeSort {
	
	public static void mergeSort(int[] arr, int left, int right) {
		
		if(left < right) {
			int mid = (left+right) / 2;		
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);	
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		// left and right array size
		int x = mid-left+1;
		int y = right-mid;
		
		// init left and right array
		int[] lArr = new int[x];
		int[] rArr = new int[y];
		
		// populate left and right array
		for(int i=0; i<x; i++) {
			lArr[i] = arr[left+i];
		}
		for(int j=0; j<y; j++) {
			rArr[j] = arr[mid+1+j];
		}
		
		int a=0, b=0, c=left;
		
		while(a < x && b < y) {
			if(lArr[a] < rArr[b]) {
				arr[c] = lArr[a];
				a++;
			} else {
				arr[c] = rArr[b];
				b++;
			}
			c++;
		}
		
		while(a < x) {
			arr[c] = lArr[a];
			a++;
			c++;
		}
		while(b < y) {
			arr[c] = rArr[b];
			b++;
			c++;
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

	
	public static void main(String[] args) {
		int[] test = {12, 11, 13, 5, 6, 7};
		mergeSort(test, 0, 5);
		System.out.println(Arrays.toString(test));
	}
}
