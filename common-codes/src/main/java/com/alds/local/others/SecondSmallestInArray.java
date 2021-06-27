/*
* Copyright (C) 2019 BlackRock.
*
* Created on Dec 3, 2019
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.alds.local.others;

import java.util.Arrays;

/**
 * @author rohsingh
 *
 */
public class SecondSmallestInArray {
    
    // O(n^2)
    public static int secondSmallest(int[] x) {
        
        int n = x.length;
        
        if(n < 2) {
            return 0;
        }
        
        Arrays.sort(x);
        
        return x[1];
    }

    // O(n)
    public static int secondSmallestE(int[] x) {
        
        int n = x.length;
        
        if(n < 2) {
            return 0;
        }
        
        int first = Integer.MAX_VALUE;
        int second = 0;
        
        for(int i =0; i<n; i++) {
            if(x[i] < first) {
                
                second = first;
                first = x[i];
                
                System.out.println(i + " : first =" +first+"," +"second ="+second);
                
            } else if(x[i] < second && x[i] > first) {
                second = x[i];
                
                System.out.println(i + " : first =" +first+"," +"second ="+second);
            }
        }
        
        return second;      
    }
    
    public static void main(String[] args) {
        int[] in = {4,6,2,9,3};
        
        //System.out.println(secondSmallest(in));
        
        System.out.println(secondSmallestE(in));
    }
    
    
}
