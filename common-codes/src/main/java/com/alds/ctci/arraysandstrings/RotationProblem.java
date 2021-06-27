package com.alds.ctci.arraysandstrings;

public class RotationProblem {
	
	// s1 is substring of s2 -> true, else false
	public static boolean isSubstring(String s1, String s2) {
		return true;
	}
	
	public static boolean isRotation(String s1, String s2) {
		String s1s2 = s1 + s2;
		return isSubstring(s2, s1s2);
	}
	
	public static void main(String[] args) {
		System.out.println("is Rotation : "+(isRotation("waterbottle", "erbottlewat")));
	}

}
