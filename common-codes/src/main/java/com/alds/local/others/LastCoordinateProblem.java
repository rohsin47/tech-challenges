/**
 * 
 */
package com.alds.local.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * @author rohsi
 * 
 * 
 * 
 	Given an input string like the following we need 
 	to print the coordinates obtained at the last 
 	character of the string.
 	
	Directions:

	L-Left
	U-Up
	R-Right
	D-Down
	X-Delete the previous move.
	
	Assumption: start with the coordinates (0,0)

	Here is how to calculate the output.

	Given Input:   3L5UR2DDX2LR
	
	Let us do step by step.
	
	3L - Move 3 points to the left of (0,0) i.e (-3,0)
	5U- Move 5 points upper to (-3,0) i.e (-3,5)
	R - Move 1 point to the right of (-3,5) i.e (-2,5)
	2D - Move 2 points down to (-2,5) i.e (-2,3)	
	D - Move 1 point further down i.e (-2,2)	
	x - Delete the previous move.(current value is (-2,3))	
	2L-Move 2 left to (-2,3) i.e(-4,3)	
	R- Move 1 Right to (-4,3) i.e (-3,3)
 *
 */
public class LastCoordinateProblem {
	
	static class Point {		
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}	
		
		Point move(Point p, int l, int s, char c) {
			if(c =='L' || c== 'R') {
				p.x = p.x + (l * s);
				return p;
			} else if (c =='U' || c== 'D'){
				p.y = p.y + (l * s);
				return p;
			} else {
				return p;
			}
		}
		
		Point update(Point p, Point l) {
			p.x = l.x;
			p.y = l.y;
			return p;
		}
		
		@Override
		public String toString() {
			return "["+x+","+y+"]";
		}
	}
	
	public static String findLastCoordinate(String input) {		
		if(input.isEmpty()) {
			return "";
		}
		
		int len = input.length();
		
		Map<Character, Integer> dataMap = new HashMap<>();
		dataMap.put('L', -1);
		dataMap.put('U', +1);
		dataMap.put('R', +1);
		dataMap.put('D', -1);
		dataMap.put('X', 0);
		
		int i=0;
		int j=0;
		
		Point start = new Point(0,0);
		
		LinkedList<Point> pos = new LinkedList<Point>();
		
		while(i<len) {
			if(!dataMap.containsKey(input.charAt(i))) {
				i++;
			} else {
				String each = input.substring(j, i+1);
				parse(each, start, dataMap, pos);
				j = j + each.length();
				i++;
			}
		}
		return start.toString();
	}
	
	public static void parse(String s, Point p, Map<Character, Integer> dataMap, 
			LinkedList<LastCoordinateProblem.Point> pos) {
		int l = s.length();
		int move = 0;	
		if(l == 1) {
			move = 1;
		} else {
			move = Integer.parseInt(s.substring(0, l-1));
		}	
		if(s.charAt(l-1) == 'X' && pos.size() > 1){
			int i = 0;
			while(i<move) {
				pos.removeLast();
				p.update(p, pos.getLast());
				i++;
			}
		} else {
			p.move(p, move, dataMap.get(s.charAt(l-1)), s.charAt(l-1));
			pos.add(new Point(p.x, p.y));
		}
	}
	
	public static void main(String[] args) {
		String test = "3L5UR2DDX2LR";
		System.out.println(findLastCoordinate(test));
	}

}
