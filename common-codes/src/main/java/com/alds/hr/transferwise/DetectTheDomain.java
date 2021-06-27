package com.alds.hr.transferwise;

import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author rohsingh
 *
 */
public class DetectTheDomain {
    
    public static void main(String[] args) {
        
        Pattern p = Pattern.compile("https?://(www.|ww2.)?([a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+)");
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        sc.nextLine();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sc.nextLine());
        }
        
        SortedSet<String> domainNames = new TreeSet<>();
        
        Matcher m = p.matcher(sb.toString());
        
        while(m.find()){
            domainNames.add(m.group(2));
        }
        
        System.out.println(String.join(";", domainNames.stream().collect(Collectors.toList())));

        sc.close();     
        
        
    }
    
    public static String getDomains(List<String> lines) {
    	if(lines.isEmpty()) {
    		return "";
    	}
    	 
    	 StringBuilder sb = new StringBuilder();
         lines.stream().forEach(data -> sb.append(data));
         
         String regex = "https?://(www.|ww2.|web.)?([a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+)";
         Pattern p = Pattern.compile(regex);
         SortedSet<String> domainNames = new TreeSet<>();
         
         Matcher m = p.matcher(sb.toString());
         
         while(m.find()){
             domainNames.add(m.group(2));
         }
         
         return String.join(";", domainNames.stream().collect(Collectors.toList()));
    }

}
