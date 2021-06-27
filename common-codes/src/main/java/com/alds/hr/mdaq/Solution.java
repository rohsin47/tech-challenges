/**
 * 
 */
package com.alds.hr.mdaq;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


/**
 * @author rohit
 *
 */
public class Solution {
	
	public int solution(String S, String T) throws ParseException {
        // write your code in Java SE 8
        if(!S.isEmpty() && !T.isEmpty()){
        	DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date t1 = formatter.parse(S);
            Date t2 = formatter.parse(T);
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(t1);
            c2.setTime(t2);
            Set<String> unique = new HashSet<>();
            List<String> result = new ArrayList<>();
            while(c1.getTimeInMillis() <= c2.getTimeInMillis()) {
            	String hour = String.format("%02d", c1.get(Calendar.HOUR_OF_DAY));
            	String min = String.format("%02d", c1.get(Calendar.MINUTE));
            	String sec = String.format("%02d", c1.get(Calendar.SECOND));  
            	System.out.println(hour +":"+min+":"+sec);
            	Stream.of(hour.split("")).forEach(data -> unique.add(data));
            	Stream.of(min.split("")).forEach(data -> unique.add(data));
            	Stream.of(sec.split("")).forEach(data -> unique.add(data));
            	
            	if(unique.size() <= 2){
            		result.add(c1.getTime().toString());
            	}
            	unique.clear();
            	c1.add(Calendar.SECOND, 1);           	
            } 
            System.out.println(result.toString());
        }
        return 0;
    }
	
	public String solution2(String S) {
		if (S.isEmpty()) {
		    return S;
		}
		char[] buf = S.toCharArray();
		char lastchar = buf[0];

		// i: index of input char
		// o: index of output char
		int o = 1;
		for (int i = 1; i < buf.length; i++) {
		    if (o > 0 && buf[i] == buf[o - 1]) {
		        lastchar = buf[o - 1];
		        while (o > 0 && buf[o - 1] == lastchar) {
		            o--;
		        }
		    } else if (buf[i] == lastchar) {
		        // Don't copy to output
		    } else {
		        buf[o++] = buf[i];
		    }
		}
		return new String(buf, 0, o);   
	}
	
	List<Integer> digits(int i) {
	    List<Integer> digits = new ArrayList<Integer>();
	    while(i > 0) {
	        digits.add(i % 10);
	        i /= 10;
	    }
	    return digits;
	}
	
	public static void main(String[] args) throws ParseException{
		//String S = "22:22:21";
		//String T = "22:22:23";
		Solution sol = new Solution();
		//sol.solution(S, T);
		
		String test = "ACCAABBC";
		System.out.println(sol.solution2(test));
		
		
	}
	
}
