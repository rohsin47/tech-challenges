package com.alds.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rohsi
 *
 */
public class Solution {

	static String[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
	static StringBuilder sb = new StringBuilder();

	public static String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}

		if (n <= 26) {
			sb.append(alpha[n - 1]);
		} else {
			// n/26 * 26 + n%26
			// 51 = 1*26 + 25
			// 52 = 1*26 + 26
			// 78 = 2*26 + 26B
			// 703 = 1*26 + 1*26 + 1
			// n/26 * 26 + n%26
			int rep = n / 26;
			int rem = n % 26;
			if (rem == 0) {
				sb.append(alpha[rep - 2]);
				sb.append(alpha[25]);
			} else {
				if (rep <= 26) {
					sb.append(alpha[rep - 1]);
				} else {
					convertToTitle(rep);
				}
				sb.append(alpha[rem - 1]);
			}
		}
		return sb.toString();
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int validPlaces = 0;
		if (flowerbed.length >= 2) {
			if (flowerbed[0] == 0 && flowerbed[1] == 0) {
				flowerbed[0] = 1;
				validPlaces++;
			}
			if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
				flowerbed[flowerbed.length - 1] = 1;
				validPlaces++;
			}
			for (int i = 1; i < flowerbed.length - 1; i++) {
				if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
					flowerbed[i] = 1;
					validPlaces++;
				}
			}
		} else {
			if (flowerbed[0] == 0) {
				validPlaces++;
			}
		}

		return validPlaces >= n;
	}

	static int repeats = 1;

	public static int repeatedStringMatch(String A, String B) {
		int q = 1;
		StringBuilder S = new StringBuilder(A);
		for (; S.length() < B.length(); q++)
			S.append(A);
		if (S.indexOf(B) >= 0)
			return q;
		if (S.append(A).indexOf(B) >= 0)
			return q + 1;
		return -1;
	}

	static int steps = 0;

	public static int numberOfSteps(int num) {
		while (num != 0) {
			steps++;
			if (num % 2 == 0) {
				return numberOfSteps(num / 2);
			} else {
				return numberOfSteps(num - 1);
			}
		}
		return steps;
	}

	public static List<String> readBinaryWatch(int num) {
		int base = Double.valueOf(Math.pow(2, 6)).intValue();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				if (Integer.bitCount(i * base + j) == num) {
					res.add(String.format("%d:%02d", i, j));
				}
			}
		}
		return res;
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] clone = nums.clone();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			map.putIfAbsent(nums[i], i);
		}

		Arrays.asList(nums);
		int[] result = new int[nums.length];
		for (int i = 0; i < clone.length; i++) {
			result[i] = map.get(clone[i]);
		}
		return result;
	}

	public static List<Integer> countSmaller(int[] nums) {
		// List<Integer> result = new ArrayList<>();

		int[] result = new int[nums.length];
		Arrays.fill(result, 0);

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					result[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(result));
		return new ArrayList<Integer>();
	}

	public static int findMaxLength(int[] nums) {
		int[] arr = new int[2 * nums.length + 1];
		Arrays.fill(arr, -2);
		arr[nums.length] = -1;
		int maxlen = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 0 ? -1 : 1);
			if (arr[count + nums.length] >= -1) {
				maxlen = Math.max(maxlen, i - arr[count + nums.length]);
			} else {
				arr[count + nums.length] = i;
			}

		}
		return maxlen;
	}

	public static int findMaxLength2(int[] nums) {
		int maxlen = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 0 ? -1 : 1);
			if (count == 0) {
				maxlen = Math.max(maxlen, i + 1);
			}
		}
		return maxlen;
	}

	public static int[] productExceptSelf(int[] nums) {
		int result[] = new int[nums.length];
		int n = nums.length;
		if (n == 1) {
			result[0] = 0;
			return result;
		}

		int left[] = new int[n];
		int right[] = new int[n];

		int i, j;

		left[0] = 1;
		right[n - 1] = 1;

		for (i = 1; i < n; i++)
			left[i] = nums[i - 1] * left[i - 1];

		for (j = n - 2; j >= 0; j--)
			right[j] = nums[j + 1] * right[j + 1];

		for (i = 0; i < n; i++)
			result[i] = left[i] * right[i];

		return result;
	}

	// only when input string have ')' and '('
	public boolean checkValidString(String s) {
		if (s.isEmpty()) {
			return true;
		}
		// how many open parenthesis we have
		int openCount = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				openCount++;
			}
			if (c == ')') {
				openCount--;
			}
			// this means invalid parenthesis ')('
			if (openCount < 0)
				return false;
		}
		return openCount == 0;
	}

	public static void main(String[] args) {
		// System.out.println(repeatedStringMatch("abcabcabcabc", "abac"));
		// System.out.println(repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
		// System.out.println(countSmaller(new int[] {5,2,6,1}));
		// System.out.println(findMaxLength(new int[] {0,1,1,0,1,1,1,0}));
		System.out.println(productExceptSelf(new int[] { 1, 2, 3, 4 }));
	}

}
