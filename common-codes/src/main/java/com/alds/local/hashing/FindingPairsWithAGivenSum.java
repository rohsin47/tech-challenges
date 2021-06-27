package com.alds.local.hashing;
import java.util.Arrays;
import java.util.HashMap;
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
	public static int findDistinctPairs(int[] arr, int k) {
	    Map<Integer, Integer> data = new HashMap<>();
	    int pairs = 0;
	    
	    for(int i=0; i<arr.length; i++) {
	        if(data.containsKey(k-arr[i])) {
	            int freq = data.get(k-arr[i])-1;
	            pairs++;
	            System.out.println(arr[i] + ", " + (k-arr[i]));  
	            if(freq==0) {
	                data.remove(k-arr[i]);
	            } else {
	                data.put(k-arr[i], freq);
	            }
	        } else {
	            if(!data.containsKey(arr[i])) {
	                data.put(arr[i], 1);
	            } else {
	                data.put(arr[i], data.get(arr[i])+1);
	            }
	        }
	    }
	    return pairs;
	}
    
    // faster and in place search (but needs sorting)
    public static void printPairsUsingTwoPointers(int[] numbers, int k) {
        if (numbers.length < 2) {
            return;
        }
        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == k) {
                System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            }
        }
    }


	public static void main(String[] args) {
		int[] test ={10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
	      int[] test2 = {1, 2, 2, 2, 3, 4, 4, 4};
		
		System.out.println("Pairs (Hashing) : "+findDistinctPairs(test, 11));
		System.out.println("Pairs (Hashing) : "+findDistinctPairs(test2, 5));
		
		System.out.println("Pairs (Two Pointers) :");
		printPairsUsingTwoPointers(test2, 5);
		
		System.out.println("Pairs (Two Pointers) :");
        printPairsUsingTwoPointers(test, 11);
	}
}
