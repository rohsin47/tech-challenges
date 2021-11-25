package org.soloactive;

import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args){
        int arr[] = {1,1,1,1,0,0,0,0};

        // Function to find minimum swaps
        System.out.println(minimumSwaps(arr, arr.length));
    }

    /**
        Given a binary array, find the number of minimum adjacent swaps needed to group 1's and 0's.
        
        Input : [0,1,0,1] (array with 0 based index)
        Swaps needed : [0,1,0,1] -> [0,0,1,1] (1 swap from index 1 to index 2)

        Solution : 1
    */
    public static int minimumSwaps(int[] a, int n) {
        int n0 = 0, i0 = 0, n1 = 0, i1 = 0;
        for (int p = 0; p < a.length; ++p) {
            if (a[p] == 0)
                n0 += p - i0++; // No. of steps to move the 0 to the left
            else
                n1 += p - i1++; // No. of steps to move the 1 to the left
        }
        return Math.min(n0, n1); //
    }

    /**
    My O(n * logn) solution to the above problem with full working code.
    The idea is first we sort array. Then if we have n channels, create n-1 channels by using the last element of the packets list (don't actually need to create n-1 lists, as these n-1 channels will only have a single element, so can use simple integer variable) and sum up all the n-1 created channels. And also delete the last element of packets list whenever a channel is created!
    Then just calculate median of remaining elements in list and add it to the above sum.
    
    E.g., I/P --> [2,2,1,5,3], channels - 3
    After sort - [1,2,2,3,5]
    
    We will create a variable/channel, such that - original packets [1,2,2] and variable sum 8 (3+5 = 8, where 3 and 5 are the newly created channels post sorting)
    Finally, calculate median of 1,2,2 which is 2 and add it to sum variable -> 8 + 2 == 10 for our answer
    */
    // TC - O(nlogn) as we are sorting
    // SC - O(1) - no data structure needed

    public static long maximumQuality(List packets, int channels) {
        if (packets == null || packets.size() == 0) return 0L;
        if (packets.size() == 1) return (long) packets.get(0);
        if (channels <= 0) {
            // TODO.. throw exception, bad input
        }

        Collections.sort(packets);
        int n = channels - 1;
        int median = 0;
        while (n-- > 0) {
            int val = (int) packets.get(packets.size()-1);
            median += val;
            packets.remove(packets.size()-1);
        }
        Long result = findMedian(packets, median);
        return result;
    }

    private static long findMedian(List list, long median) {
        long val = 0;
        if (list.size() %2 == 0) {
            val =  ((long) list.get(list.size()/2) + (long) list.get(list.size()/2 - 1))/2;
        } else {
            val = (long) list.get(list.size()/2);
        }
        return (long) (val + median);
    }
}
