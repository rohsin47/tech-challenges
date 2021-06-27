package com.alds.hr.transferwise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rohsingh
 *
 */
public class IntegerToRoman {
    
    public static List<String> intToRoman(List<Integer> nums) {
    	if(nums.isEmpty()) {
    		return new ArrayList<>();
    	}
    		
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    	
    	List<String> out = new ArrayList<>();
    	
    	for(Integer in : nums) {
    		out.add(M[in/1000] + C[(in%1000)/100] + X[(in%100)/10] + I[in%10]);
    	}

        return out;
    }
    
    public static String intToRoman2(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        long start = System.nanoTime();
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println(intToRoman(nums));
        long finish = System.nanoTime() - start;      
        System.out.println("- in " +finish);
    }

}
