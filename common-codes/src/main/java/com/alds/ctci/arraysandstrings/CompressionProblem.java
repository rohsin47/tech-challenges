package com.alds.ctci.arraysandstrings;

public class CompressionProblem {

	public static String compress(String in) {

		if (in.length() == 0 || in.length() == 1) {
			return in;
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		for(int i=0; i<in.length(); i++) {
			count++;
			if(i+1 >= in.length() || in.charAt(i) != in.charAt(i+1)) {
				sb.append(in.charAt(i));
				sb.append(count);
				count =0;
			}
		}
		if(in.length() == sb.length()) {
			return in;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String in = "aabccccaaa";
		System.out.println("Compressed : "+compress(in));
	}
}
