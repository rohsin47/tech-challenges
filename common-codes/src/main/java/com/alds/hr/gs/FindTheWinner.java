package com.alds.hr.gs;

import java.util.LinkedList;

public class FindTheWinner {

	public static void main(String[] args) {
		System.out.println("Winner : "+find(4, 2));
	}
	
	public static int find(int n, int k) {
		
		LinkedList<Integer> data = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			data.add(i);
		}
		
		if(data.size() == 1) {
			return data.get(0);
		}
		
		while(data.size() > 1) {
			for(int i=0; i<data.size(); i++) {
				if(data.get(i) % k == 0) {
					data.remove(i);
				}
			}
		}
		
		return data.get(0);
		
	}

}
