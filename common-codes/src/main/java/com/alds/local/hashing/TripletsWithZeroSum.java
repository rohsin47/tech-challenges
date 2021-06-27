package com.alds.local.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author rohsingh
 * 
 *         Given an array of distinct elements. The task is to find triplets in
 *         array whose sum is zero.
 * 
 *         Input : arr[] = {0, -1, 2, -3, 1} 
 *         Output : 0 -1 1 2 -3 1
 *         Input : arr[] = {1, -2, 1, 0, 5} 
 *         Output : 1 -2 1
 *
 */
public class TripletsWithZeroSum {

    public static void findB(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println("Triplet : {" + arr[i] + "," + arr[j] + "," + arr[k] + "}");
                    }
                }
            }
        }
    }

    public static void findE(int[] arr) {
        int n = arr.length;  
        for(int i=0; i<n-1; i++) {    
            // we will find all pairs with -arr[i]  
            Map<Integer, Integer> data = new HashMap<>();
            for(int j=i+1; j<n; j++) {
                int x = -(arr[i] + arr[j]);
                //  sum should to equal to element in an array, we are checking if any summed up element is there
                if(data.containsKey(x)) {
                    System.out.println("Triplet : {" + x + "," + arr[i] + "," + arr[j] + "}");
                } else {
                    // put that element which pair to get 0
                    data.put(arr[j], arr[j]);
                }
            }
        } 
    }
    

    public static List<List<Integer>> threeSum(int[] nums) {       
        int n = nums.length;       
        Set<List<Integer>> res = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            Map<Integer, Integer> data = new HashMap<>(); 
            for(int j=i+1; j<n; j++) {
                int x = -(nums[i] + nums[j]);
                if(data.containsKey(x)) {
                    List<Integer> mid = new ArrayList<>();
                    mid.add(x);
                    mid.add(nums[i]);
                    mid.add(nums[j]); 
                    Collections.sort(mid);
                    res.add(mid);
                } else {
                    data.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] test = {-1,0,1,2,-1,-4};
        System.out.println(Arrays.toString(threeSum(test).toArray()));
    }

}
