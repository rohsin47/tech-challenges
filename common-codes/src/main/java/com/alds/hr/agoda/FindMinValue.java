package com.alds.hr.agoda;

/**
 * 
 * 
 * Minimum Start Value
 * 
 * 
 * Given array of integers. Calculate a running sum of x plus each array element, from left to right. 
 * The running sum must never get below 1. Given an array of integers, determine the minimum value of x.
 * For Example, arr = [-2, 3, 1, -5]. If x = 4, the following results are obtained:
    
    RunningSum              arr[i]
    ------------            -------------
        4                      -2
        2                       3
        5                       1
        6                      -5
        1

 * The Final value is 1, and the running sum has never dropped below 1. 
 * The minimum starting value for x is 4.
 * 
 * 
 * rohsingh
 * 
 */
public class FindMinValue {

    public static int findMinValue(int[] arr) {
        int n = arr.length;
        int guess = -1000;
        int runningSum;
        boolean found = false;
        while (!found) {
            runningSum = guess;
            for (int i = 0; i < n; i++) {
                runningSum += arr[i];
                if (runningSum < 1) {
                    guess++;
                    break;
                }
                if (i == n - 1) {
                    found = true;
                }
            }
        }
        return guess;
    }

    public static void main(String[] args) {
        int[] test = { -2, 3, 1, -5 };
        int[] test2 = { -5, 4, -2, 3, 1 };
        System.out.println(findMinValue(test));
        System.out.println(findMinValue(test2));
    }

}
