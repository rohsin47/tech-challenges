package com.alds.local.pathFinding;

/**
 * @author rohsingh
 * 
 * Given a matrix of N * M. Find the maximum path sum in matrix. 
 * The maximum path is sum of all elements from first row to last 
 * row where you are allowed to move only down or diagonally to left 
 * or right. You can start from any element in first row.
 * 
 * 
 * 	Input : mat[][] = 	1 2 3
                  		9 8 7
                  		4 5 6
	Output : 17
	The maximum sum path is 3-8-6.
 *
 */
public class MaximumPathSumInMatrix {
		
	public static int findMaximumPathSum(int[][] M, int R, int C) {
		int res = 0;
		
		// first row - max - this is to handle if there is just one row
		for(int j=0; j<C; j++) {
		    res = Math.max(res, M[0][j]);
		}
		
		System.out.println("Result : "+res);
		
		// start from second row - follow bottom up approach (main solution)
		for(int i=1; i<R; i++) {	
		    //reset result
		    res = 0;
			for(int j=0; j<C; j++) {
			    
				// middle
				if(j > 0 && j < C-1) {
					M[i][j] += Math.max(M[i-1][j-1], Math.max(M[i-1][j], M[i-1][j+1]));
					System.out.println("Result for i="+i+",j="+j+"->"+M[i][j]);
				}
				
                // extreme right, no diagonal right
				else if(j > 0) {
				    M[i][j] += Math.max(M[i-1][j], M[i-1][j-1]);
				    System.out.println("Result for i="+i+",j="+j+"->"+M[i][j]);
                }
                			
				// extreme left, no diagonal 
				else if(j < C-1) {
				    M[i][j] += Math.max(M[i-1][j], M[i-1][j+1]);
				    System.out.println("Result for i="+i+",j="+j+"->"+M[i][j]);
				}
				
				res = Math.max(M[i][j], res);
				System.out.println("Result Final : "+res);
			}
		}
		return res;
	}

	
	public static void main(String[] args) {
		 int m1[][] = { 
				 	{1, 2, 3},
				 	{9, 8, 7},
				 	{4, 5, 6} 
             }; 
		 
		 int m2[][] = { { 10, 10, 2, 0, 20, 4 }, 
                 { 1, 0, 0, 30, 2, 5 }, 
                 { 0, 10, 4, 0, 2, 0 }, 
                 { 1, 0, 2, 20, 0, 4 }  
             }; 
		 
		 int m3[][] = { 
                 {1, 2, 3}
          }; 

		 System.out.println(findMaximumPathSum(m1,3,3)); 
		 System.out.println(findMaximumPathSum(m2,4,6)); 
		 System.out.println(findMaximumPathSum(m3,1,3)); 
	}
}
