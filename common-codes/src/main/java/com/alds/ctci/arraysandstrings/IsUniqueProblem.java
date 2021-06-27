/**
 * 
 */
package com.alds.ctci.arraysandstrings;

import java.util.BitSet;

/**
 * @author rohsi
 *
 */
//assume only ASCII chars (0-127)
public class IsUniqueProblem {
	
	// char array - ascii codes
	// assume only ASCII chars
	public static boolean isUnique1(String in) {
		char[] ch = new char[128];
		
		if(in.isEmpty()) {
			return false;
		}
		
		for(int i=0; i<in.length(); i++) {
			ch[in.charAt(i)]++;
		}
		
		for(int i=0; i<in.length(); i++) {
			if(ch[in.charAt(i)] > 1) {
				return false;
			}
		}
		return true;
	}
	
	// boolean char array
	// this will reduce two loops
	public static boolean isUnique2(String in) {
		boolean[] res = new boolean[128];
		
		if(in.isEmpty()) {
			return false;
		}
		
		for(int i=0; i<in.length(); i++) {
			char ch = in.charAt(i);
			if(res[ch]) {
				return false;
			}
			res[ch] = true;
		}
		return true;
	}
	
	public static boolean isUnique3(String in) {
		BitSet bt = new BitSet(128);
		
		if(in.isEmpty()) {
			return false;
		}
		
		for(int i=0; i<in.length(); i++) {
			if(bt.get(in.charAt(i))) {
				return false;
			} else {
				bt.set(in.charAt(i));
			}
		}
		return true;	
	}
	
	public static boolean isUnique4(String in) {
		if(in.isEmpty()) {
			return false;
		}
		int checker = 0;
		for(int i=0, n=in.length(); i<n; i++) {
			int val = in.charAt(i);
			if((checker & (1 >> val)) > 0) {
				return false;
			}
			checker = checker | 1 >> val;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String in = "abcdefgh";
		System.out.println("is Unique 1 : "+in+":"+ isUnique1(in));
		System.out.println("is Unique 2 : "+in+":"+ isUnique2(in));
		System.out.println("is Unique 3 : "+in+":"+ isUnique3(in));
		System.out.println("is Unique 4 : "+in+":"+ isUnique4(in));
	}

}
