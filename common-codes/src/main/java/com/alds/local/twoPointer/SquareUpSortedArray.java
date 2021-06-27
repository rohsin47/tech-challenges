/*
* Copyright (C) 2019 BlackRock.
*
* Created on Nov 22, 2019
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.alds.local.twoPointer;

import java.util.Arrays;

/**
 * @author rohsingh
 * 
 * 
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * 
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 *
 */
public class SquareUpSortedArray {
    
    public static int[] sortedSquares(int[] A) {
        
        int n = A.length;
        
        // first pointer
        int j = 0;
        
        while(j < n && A[j] < 0) {
            j++;
        }
        
        // second pointer
        int i = j-1;
        
        // store result
        int[] res = new int[n];
        int t = 0;
        
        while(i>=0 && j<n) {
            if(A[i] * A[i] < A[j] * A[j]) {
                res[t++] = A[i] * A[i];
                i--;
            } else {
                res[t++] = A[j] * A[j];
                j++;
            }
        }
        
        while(i>=0) {
            res[t++] = A[i] * A[i];
            i--;
        }
        
        while(j < n) {
            res[t++] = A[j] * A[j];
            j++;
        }
        
        return res;    
    }
    
    public static void main(String[] args) {
        int[] test = {-7, -5, -3, 2, 6, 8};
        System.out.println("Result : "+Arrays.toString(sortedSquares(test)));
    }

}
