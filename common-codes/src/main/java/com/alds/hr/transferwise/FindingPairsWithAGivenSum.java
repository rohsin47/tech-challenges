package com.alds.hr.transferwise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author rohsi
 * 
 *         Input : arr[] = {1, 5, 7, -1}, sum = 6 
 *         Output : 2 Pairs with sum 6
 *         are (1, 5) and (7, -1)
 *
 */
public class FindingPairsWithAGivenSum {

	public static void findPairsB(int[] arr, int sum) {
		int i = 0;
		int n = arr.length;
		while (i < n - 1) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.println("its a pair : " + "{" + arr[i] + "," + arr[j] + "}");
				}
			}
			i++;
		}
	}
	
	public static int findNumberOfPairsE(int[] arr, int sum) {
		int n = arr.length;
		Map<Integer, Integer> data = new HashMap<>();
		for(int i=0; i<n; i++) {
			if(!data.containsKey(arr[i])) {
				data.put(arr[i], 1);
			} else {
			    data.put(arr[i], data.get(arr[i])+1);
			}
		}
		
		int twiceCount = 0;
		for(int i=0; i<n; i++) {
			if(data.containsKey(sum-arr[i])) {
				twiceCount += data.get(sum-arr[i]);
				System.out.println("its a pair : " + "{" + arr[i] + "," + (sum-arr[i]) + "}");
			}
			if(sum-arr[i] == arr[i]) {
				twiceCount--;
			}
		}	
		return twiceCount / 2;
	}
	
	// requires extra space
	public static int findDistinctPairs(List<Integer> arr, long k) {
	    Map<Integer, Integer> data = new HashMap<>();
	    int pairs = 0;
	    
	    for(int i=0; i<arr.size(); i++) {
	    	int res = (int) (k-arr.get(i));
	        if(data.containsKey(res)) {        	
	            int freq = data.get(res)-1;
	            pairs++;
	            System.out.println(arr.get(i) + ", " + (k-arr.get(i)));  
	            if(freq==0) {
	                data.remove(res);
	            } else {
	                data.put(res, freq);
	            }
	        } else {
	            if(!data.containsKey(arr.get(i))) {
	                data.put(arr.get(i), 1);
	            } else {
	                data.put(arr.get(i), data.get(arr.get(i))+1);
	            }
	        }
	    }
	    return pairs;
	}
    
    // faster and in place search (but needs sorting)
    public static int printPairsUsingTwoPointers(List<Integer> arr, long k) {
        if (arr.size() < 2) {
            return 0;
        }
        Collections.sort(arr);
        
        List<String> noDups = new ArrayList<String>();

        int pairs = 0;
        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum == k) {
            	pairs++;
                System.out.printf("(%d, %d) %n", arr.get(left), arr.get(right));
                noDups.add(arr.get(left)+":"+arr.get(right));
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            }
        }
        return (int) noDups.stream().distinct().count();
    }


	public static void main(String[] args) {
		int[] test ={10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
	    int[] test2 = {1, 2, 2, 2, 3, 4, 4, 4};
		
		//System.out.println("Pairs (Hashing) : "+findDistinctPairs(test, 11));
		
		List<Integer> data = new ArrayList<Integer>();
		data.add(5);
		data.add(7);
		data.add(9);
		data.add(13);
		data.add(11);
		data.add(6);
		data.add(6);
		data.add(3);
		data.add(3);
		data.add(5);
		data.add(7);
		
		System.out.println("Pairs (Hashing) : "+findDistinctPairs(data, 12));
		
		System.out.println("Pairs (Two Pointers) :"+printPairsUsingTwoPointers(data, 12));
		//printPairsUsingTwoPointers(test2, 5);
		
		System.out.println("Pairs (Two Pointers) :");
        //printPairsUsingTwoPointers(test, 11);
	}
	
	
}
