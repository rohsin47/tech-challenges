package com.alds.local.cyclicSort;

import java.util.Arrays;

/**
 * @author rohsingh
 * 
 * You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in the list. One of the integers is missing in the list. 
 * Write an efficient code to find the missing integer.
 * 
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * Output: 5
 *
 */
public class MissingNumber {
    
    // O(nlogn)
    public static int findB(int[] arr) {      
        Arrays.sort(arr);        
        int n = arr.length;       
        for(int i=0; i<n; i++) {
            if(arr[i] != (i+1)) {
                return i+1;
            }
        }
        return 0;    
    }
    
    // O(n)
    public static int findE(int[] arr) {
        int n = arr.length;       
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
        }
        int actual = n * (n+1) / 2;
        return actual -sum;
    }
    

    public static void main(String[] args) {
        int[] test = {1, 2, 4, 6, 3, 7, 8};
        System.out.println("Missing number : "+findB(test));
        findE(test);
    }

}
