package com.alds.hr.visa;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/*
 * Given an array of non-empty strings, return a Map<String, String> with a key
 * for every different first character seen, with the value of all the strings
 * starting with that character appended together in the order they appear in
 * the array. firstChar(["salt", "tea", "soda", "toast"]) → {"t": "teatoast",
 * "s": "saltsoda"} firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"d":
 * "d", "b": "bb", "c": "cccCC", "a": "aaaAA"} firstChar([]) → {}
 */

public class ArrayToMap {

	public String generateMap(String[] strings) {
		Map<String, String> map = new HashMap<>();
		for (String s : strings) {
			if (!map.containsKey(s.substring(0, 1))) {
				map.put(s.substring(0, 1), s);

			} else {
				String existing = map.get(s.substring(0, 1));
				map.put(s.substring(0, 1), existing + "#" +s);
			}
		}
		
		StringJoiner joiner = new StringJoiner(" , ");
		map.entrySet().forEach(each -> {
			joiner.add(each.getKey() + ":" + each.getValue());
		});
		
		return joiner.toString();
	}

}
