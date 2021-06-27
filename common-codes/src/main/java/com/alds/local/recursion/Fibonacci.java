package com.alds.local.recursion;

/**
 * @author rohsingh
 *
 */
public class Fibonacci {
    
    // recursion - costly affair
    public static int buildFibonacci(int n) {      
        if(n<=1) {
           return n; 
        } else {
            return buildFibonacci(n-1) + buildFibonacci(n-2);
        }
    }

    // dynamic programming - memoization technique
    public static int buildFibonacciE(int n) {
        int[] r = new int[n+2];
        r[0] = 0;
        r[1] = 1;
        for(int i=2; i<=n; i++) {
            r[i] = r[i-2] + r[i-1];  
        }
        return r[n];
    }

    
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("Fibonacci Series [recursion] : "+buildFibonacci(9)); 
        long end = System.nanoTime();
        double diff = start-end / 1000000000.0;
        System.out.println("Fibonacci Series [recursion time] : "+diff); 
        
        start = System.nanoTime();
        System.out.println("Fibonacci Series [dp-memoization] : "+buildFibonacciE(9)); 
        end = System.nanoTime();
        diff = start-end / 1000000000.0;
        System.out.println("Fibonacci Series [dp-memoization time] : "+diff); 
    }
    
}
