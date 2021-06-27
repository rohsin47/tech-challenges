package com.alds.local.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
You have a group of people with their birth years and death years, how would you find the year with most people alive.
Example:
    P1: 1982, 2017
    P2: 1923, 2004
    P3: 1988, 2015
    P4: 1910, 1988
    P5: 1990, 2005
    P6: 2004, 2010
    
    Ans - 2004

B-1910 B-1923 B-1982 B-1988 D-1989 B-1990 B-2004 D-2005 D-2006 D-2011 D-2016 D-2018
   1      2      3     4      3       4     5      4      3      2      1      0
 */
public class MaximumPeopleAlive {
    
    static class People {      
        String id;
        int birth;
        int death;
        
        People(String id, int birth, int death) {
            super();
            this.id = id;
            this.birth = birth;
            this.death = death;
        }     
    }
    
    public static int findMaximumPeopleAliveYear(List<People> ps) {
        
        int i=0, j=0;
        
        int[] births = new int [ps.size()];     
        int[] deaths = new int [ps.size()];     
        
        for(int k=0; k<ps.size(); k++) {
            births[k] = ps.get(k).birth;
            deaths[k] = ps.get(k).death;
        }
        
        Arrays.sort(births);
        Arrays.sort(deaths);
             
        Map<Integer, Integer> data = new TreeMap<>();
        
        int pop = 1;
        
        //[1910, 1923, 1982, 1982, 1988, 1990]
        //[1988, 2004, 2005, 2010, 2015, 2017]
        while(i<births.length && j<deaths.length) {
            if(births[i] < deaths[j]) {
                if(!data.containsKey(births[i])) {
                   data.put(births[i], pop++);
                } else {
                    data.put(births[i], data.get(births[i])+1);
                }
                i++;
            } else if(births[i] > deaths[j]) {
                if(!data.containsKey(deaths[j])) {
                    data.put( deaths[j], pop--);
                } else {
                    data.put(deaths[j], data.get(deaths[j])-1);
                }
                j++;
            } else {
                if(!data.containsKey(births[i])) {
                    data.put(births[i], pop++);
                    data.put(deaths[j], data.get(births[i])-1);
                } 
                i++;
                j++;
            }
        }
        
        // left over
        while(i<births.length) {
            if(!data.containsKey(births[i])) {
                data.put(births[i], 1);
            } else {
                data.put(births[i], data.get(births[i])+1);
            }
            i++;
        }
        
        // left over
        while(j<deaths.length) {
            if(!data.containsKey(deaths[j])) {
                data.put( deaths[j], -1);
            } else {
                data.put(deaths[j], data.get(deaths[j])-1);
            }
            j++;
        }
        
        // use a Treemap instead
        // Map<Integer, Integer> sortedData = data.entrySet().stream()
        //.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
        // .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        System.out.println(data);
        
        int maxP = 0;
        int year = 0;
        
        for(Map.Entry<Integer, Integer> e : data.entrySet()) {
            if(maxP < e.getValue()){
                maxP = e.getValue();
                year = e.getKey();
            }
        }
        
        return year;
    }

    
    public static void main(String[] args) {        
        People p1 = new People("P1", 1982, 2017);
        People p2 = new People("P2", 1923, 2004);
        People p3 = new People("P3", 1988, 2015);
        People p4 = new People("P4", 1910, 1988);
        People p5 = new People("P5", 1990, 2005);
        People p6 = new People("P6", 2004, 2010);
        
        List<People> in = new ArrayList<>();
        in.add(p1);
        in.add(p2);
        in.add(p3);
        in.add(p4);
        in.add(p5);
        in.add(p6);
        
        System.out.println(findMaximumPeopleAliveYear(in));
    }
}
