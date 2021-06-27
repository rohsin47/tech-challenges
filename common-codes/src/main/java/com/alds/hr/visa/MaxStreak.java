/**
 * 
 */
package com.alds.hr.visa;

/**
 * @author rohsi
 *
 */
public class MaxStreak {
	
	/* Add checks for input range */
	public static int maxStreak(int m, String[][] data) {
		int result = 0;
		boolean found;
		if(data.length  > 0) {			
			for(int i=0; i<data.length; i++) {
				found = true;
				for(int j=0; j<data[i].length; j++) {
					if(!"Y".equals(data[i][j])) {
						found = false;
						break;
					}
				}
				if(found) {
					result++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Result for 1 : "+ maxStreak(3, new String[][]{{"N", "Y", "Y"}}));
		System.out.println("Result for 2 : "+ maxStreak(2, new String[][]{{"Y", "N"}, {"N", "Y"}}));
		System.out.println("Result for 3 : "+ maxStreak(2, new String[][]{{"Y", "Y"}, {"N", "Y"}}));
		System.out.println("Result for 4 : "+ maxStreak(4, new String[][]{{"Y", "N", "N", "Y"}, {"Y", "Y", "Y", "Y"}, {"Y", "Y", "Y", "Y"}, {"Y", "Y", "N", "Y"}, {"N", "Y", "Y", "N"}}));
	}

}
