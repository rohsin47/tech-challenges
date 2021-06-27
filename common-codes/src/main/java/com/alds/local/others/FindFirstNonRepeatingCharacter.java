/*
* Copyright (C) 2019 BlackRock.
*
* Created on Dec 2, 2019
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.alds.local.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rohsingh
 *
 */
public class FindFirstNonRepeatingCharacter {
    
    public int find(String in) {
        if(in.length()==0) {
            return -1;
        }
        if(in.length() ==1){
            return -1;
        }
        
        // boolean[] check = new boolean[128];
        char[] data = new char[256];
        
        for(int i=0; i<in.length(); i++){
            data[in.charAt(i)]++;       
        }
        
        for(int i=0; i<in.length(); i++) {
            if(data[in.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
    
    public int findIndex(String in) {
        
        Map<Character, Integer> dataMap = new HashMap<>();
        
        for(int i=0; i<in.length(); i++){
            if(!dataMap.containsKey(in.charAt(i))){
                dataMap.put(in.charAt(i), 1);
            } else {
                dataMap.put(in.charAt(i), dataMap.get(in.charAt(i))+1);
            }
        }
        
        for(int i=0; i<in.length(); i++) {
            if(dataMap.get(in.charAt(i)) == 1){
                return i;
            } 
        }
        return -1;
    }
    
    public static void main(String[] args) {
        FindFirstNonRepeatingCharacter f = new FindFirstNonRepeatingCharacter();
        System.out.println("Result : "+f.findIndex("eekkssOOrrggeff"));
        System.out.println("Result : "+f.find("eekkssOOrrggeff"));
    }
    

}
