/**
 * 
 */
package com.alds.ctci.arraysandstrings;

import java.util.regex.Pattern;

/**
 * @author rohsi
 *
 */
public class URLifyProblem {
	
	public static String urlify(String in, int l) {
		if(in.isEmpty()) {
			return in;
		}
		
		return in.trim().replaceAll(Pattern.quote(" "), "%20");
	}
	
	public static String urlifyinplace(String in, int l) {
		if(in.isEmpty()) {
			return in;
		}
		
		int space=0;
		for(int i=0;i<l;i++) {
			if(in.charAt(i) == ' ') {
				space++;
			}
		}
		
		int index = l + space * 2;
		
		char[] inArr = in.toCharArray();
		
		for(int i=l-1; i>=0; i--) {
			char o = in.charAt(i);
			if(o == ' ') {
				inArr[index-1] = '0';
				inArr[index-2] = '2';
				inArr[index-3] = '%';
				index = index-3;
			} else {
				inArr[index-1] = o;
				index--;
			}
		}
		return String.valueOf(inArr);
	}
	
	public static String urlifyinplace2(String in, int l) {
		if(in.isEmpty()) {
			return in;
		}
		
		int index = in.length();
		
		char[] inArr = in.toCharArray();
		
		for(int i=l-1; i>=0; i--) {
			char o = in.charAt(i);
			if(o == ' ') {
				inArr[index-1] = '0';
				inArr[index-2] = '2';
				inArr[index-3] = '%';
				index = index-3;
			} else {
				inArr[index-1] = o;
				index--;
			}
		}
		return String.valueOf(inArr);
	}
	
	public static void main(String[] args) {
		String in = "Mr John Smith    ";
		//System.out.println("Urlified :"+urlify(in, 13));
		System.out.println("Urlified :"+urlifyinplace2(in, 13));
	}

}
