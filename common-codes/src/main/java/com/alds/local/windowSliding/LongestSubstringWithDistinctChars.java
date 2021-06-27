package com.alds.local.windowSliding;

/**
 * @author rohsingh
 * 
 *  Find the longest substring with K unique characters 
   
   "aabbcc", k = 1
    Max substring can be any one from {"aa" , "bb" , "cc"}.
    
    "aabbcc", k = 2
    Max substring can be any one from {"aabb" , "bbcc"}.

    "aabbcc", k = 3
    There are substrings with exactly 3 unique characters
    {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
    Max is "aabbcc" with length 6.
 *
 */
public class LongestSubstringWithDistinctChars {
	
	public String findB(String str, int k) {
	
		int n = str.length();
		String res;
		
		int i = 1;
		String start = str.substring(k-1);
		
		while(i < n) {
			res = str.substring(i);
			i++;
		}		
		return str;
	
	}
	

}
