package com.alds.local.windowSliding;

/**
 * @author rohsingh
 * 
 *  Given an array of integers of size ‘n’.
    Our aim is to calculate the maximum sum of ‘k’ 
    consecutive elements in the array.
    
    
    Input  : arr[] = {100, 200, 300, 400}
         k = 2
    Output : 700

    Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
    Output : 39
    We get maximum sum by adding subarray {4, 2, 10, 23}
    of size 4.

    Input  : arr[] = {2, 3}
         k = 3
    Output : Invalid
 *
 */
public class MaximumConsecutiveSubsetSumInArray {
    
    public static int calculateB(int[] input, int k) {      
       if(input.length == 0 || k > input.length) {
           return 0;
       }

       int maxSum = 0;
       for(int i=0; i<input.length; i++) {
    	   int sum = 0;
           for(int j=0; j<k; j++) {
        	   if(i+j < input.length) {
        		   sum = sum + input[i+j];
        	   }
           }
           if(sum > maxSum) {
    		   maxSum = sum;
    	   }
       }  
       return maxSum;
    }
    
    /* O(k+n) complexity - window sliding technique */
    public static int calculateE(int[] input, int k) {
    	if(input.length == 0 || k > input.length) {
            return 0;
        }
    	
    	int startSum = 0;
    	for(int i=0; i<k; i++) {
    		startSum += input[i];
    	}
    	
    	int maxSum =0;
    	for(int i=k; i<input.length; i++) {
    		startSum += input[i] - input[i-k];
    		maxSum = Math.max(startSum, maxSum);
    	}
    	
    	return maxSum;
    }
    
    public static void main(String[] args) {
    	int[] test = {1, 4, 2, 10, 23, 3, 1, 0, 20};
    	System.out.println("Result : "+calculateE(test, 4));
    }

}
