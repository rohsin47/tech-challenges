package com.alds.local.others;

/**
 * @author rohsi
 *
 */
public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int len = nums1.length + nums2.length;

		int[] result = new int[len];

		int i = 0, j = 0, k = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				result[k] = nums1[i];
				i++;
			} else {
				result[k] = nums2[j];
				j++;
			}
			k++;
		}

		while (i < nums1.length) {
			result[k] = nums1[i];
			i++;
			k++;
		}

		while (j < nums2.length) {
			result[k] = nums2[j];
			j++;
			k++;
		}

		double d = 0.0d;

		int r = result.length;

		if (r % 2 == 0) {
			d = (result[r / 2] + result[(r / 2) - 1]) / 2;
		} else {
			d = result[r / 2];
		}
		return d;
	}
	
	  
    public static void main(String[] args) {        
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
