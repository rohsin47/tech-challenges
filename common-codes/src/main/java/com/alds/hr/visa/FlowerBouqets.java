/**
 * 
 */
package com.alds.hr.visa;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rohsi
 *
 */
public class FlowerBouqets {
	
	public enum FLOWER_TYPES {
		TYPE1, TYPE2, MIXTYPES;
	}

	/* Add checks for input range */
	public static int calculateMaxBenefit(Integer p, Integer q, String input) {
		int result = 0;
		if (input.length() < 2) {
			return result;
		}
		
		Map<FLOWER_TYPES, Integer> types = new EnumMap<>(FLOWER_TYPES.class);
		types.put(FLOWER_TYPES.TYPE1, calc(p, q, input, "(000)+?"));
		types.put(FLOWER_TYPES.TYPE2, calc(p, q, input, "(01|10)+?"));
		types.put(FLOWER_TYPES.MIXTYPES, calc(p, q, input, "(000|01|10)+?"));	
		
		return types.values().stream().max(Comparator.comparing(i->i)).get();
	}
	
	public static int calc(Integer p, Integer q, String input, String regex) {
		int result = 0;
		Matcher m3 = Pattern.compile(regex).matcher(input);
		while(m3.find()){
			if("000".equals(m3.group())){
				result += p;
			} else if("01".equals(m3.group()) || "10".equals(m3.group())){
				result += q;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Result for 0001000 : "+ calculateMaxBenefit(3, 2, "0001000"));
		System.out.println("Result for 1001000 : "+ calculateMaxBenefit(3, 2, "1001000"));
	}

}
