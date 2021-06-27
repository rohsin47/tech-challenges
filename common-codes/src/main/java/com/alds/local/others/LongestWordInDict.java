/**
 * 
 */
package com.alds.local.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rohsi
 *
 */
public class LongestWordInDict {
	
	public static String longestWord(String[] words) {
        
        if(words.length == 0) {
            return "";
        }
        
        Set<String> wordsSet = new HashSet<>();
        for(int i=0; i<words.length; i++) {
            wordsSet.add(words[i]);
        }
        
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<words.length; i++){
            String elem = words[i];
            int len = elem.length();         
            int k=0;
            boolean isPresent = true;
            
            while(k<len) {
            	String ind = elem.substring(0,k+1);
                if(!wordsSet.contains(ind)){
                    isPresent = false;
                }
                k++;
            }
            if(isPresent) {
                result.add(elem);
            }
        }
        
        if(result.isEmpty()) {
            return "";
        }
        
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }
                return s1.compareTo(s2);
            }   
        });
        
        return result.get(0);
	}
	
	public static String longestWordAnother(String[] words, String in) {
	    
	    if(words.length == 0) {
	        return "";
	    }
	    
	    List<String> matched = new ArrayList<>();
	    
	    char[] inA = in.toCharArray();
	    Arrays.sort(inA);
	    
	    for(int i=0; i<words.length; i++) {
	        char[] inB = words[i].toCharArray();
	        // check if element contains input elements
            List<Character> inLA = new ArrayList<>();
            List<Character> inLB = new ArrayList<>();
            int j=0, k=0;
            while(j<inA.length) {
                inLA.add(inA[j]);
                j++;
            }
            while(k<inB.length){
               inLB.add(inB[k]);
               k++;
            }
            if(inLA.containsAll(inLB)){
                matched.add(words[i]);
            }
	    }
	    
	    System.out.println(matched);
	    
	    Collections.sort(matched, new Comparator<String>() {

	      @Override
          public int compare(String s1, String s2) {
              if(s1.length() != s2.length()) {
                  return s2.length() - s1.length();
              }
              return s1.compareTo(s2);
          }        
        }); 
	    
	    System.out.println(matched);
	    
	    return matched.get(0);

	}

	public static void main(String[] args) {
        String[] in = {"w","wo","wor","worl","world"};
        System.out.println(longestWord(in));
        
        String[] in2 = {"to","banana","toes","dogs","ababacd", "elephant"};
        System.out.println(longestWordAnother(in2, "eot")); 
        System.out.println(longestWordAnother(in2, "ogtdes")); 
    }
}
