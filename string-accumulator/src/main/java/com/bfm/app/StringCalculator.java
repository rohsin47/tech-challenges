package com.bfm.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author rohsingh
 * 
 * 
String Accumulator
1. Create a simple string calculator with a method int add(String numbers)
	a. The method can take 0, 1 or 2 numbers and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2”
	b. Start with the simplest test case of an empty string and move to 1 and 2 numbers.
2. Allow the add method to handle an unknown amount of numbers.
3. Allow the add method to handle new lines between numbers (instead of commas).
	a. The following input is ok: “1\n2,3” (will equal 6).
	b. The following input is NOT ok: “1,\n” (don’t need to prove it - just clarifying).
4. Support different delimiters.
	a. To change a delimiter, the beginning of the string will contain a separate line that looks like this: “//<delimiter>\n<numbers…>”, for example “//;\n1;2” should return 3 where the delimiter is ‘;’.
	b. The first line is optional, all existing scenarios should still be supported.
5. Calling add with a negative number will throw an exception with the message “negatives not allowed” - and the negative that was passed.
	a. If there are multiple negatives, show all of them in the exception message.
6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2.
7. Delimiters can be of any length, for example: “//***\n1***2***3” should return 6.
8. Allow multiple delimiters like this: “//delim1|delim2\n” (with a “|” separating delimiters), for example “//*|%\n1*2%3” should return 6.
9. Make sure you can also handle multiple delimiters with length longer than one character.
 *
 */

public class StringCalculator {

	private static final Logger Log = Logger.getLogger(StringCalculator.class.getName());

	public StringCalculator() {
		Log.info("StringCalculator Initialized ...");
	}

	public int add(String numbers) {
		int result = 0;

		// Return zero if empty
		if (StringUtils.isEmpty(numbers)) {
			return result;
		}
		
		// Get pattern and matcher regex - do like that till we move to Java 9
		Matcher m  = Pattern.compile("[+-]?\\b\\d+\\b").matcher(numbers);
		List<String> allNumbersOnly = new ArrayList<>();
		while (m.find()) {
			allNumbersOnly.add(m.group());
		}
		
		// partition numbers by sign (+ve or -ve) 
		Map<Boolean, List<Integer>> numbersBySign = allNumbersOnly.stream()
				.mapToInt(Integer::parseInt).boxed().collect(Collectors.partitioningBy(x -> x > 0));

		// get the result finally
		if (numbersBySign != null && !numbersBySign.isEmpty()) {

			List<Integer> negatives = numbersBySign.get(Boolean.FALSE);

			// exception for negative numbers
			if (CollectionUtils.isNotEmpty(negatives)) {
				throw new RuntimeException("negatives not allowed : "
						+ negatives.stream().map(Object::toString).collect(Collectors.joining(",")));
			}

			List<Integer> positives = numbersBySign.get(Boolean.TRUE);

			// sum for positive numbers
			result = positives.stream().filter(x -> x < 1000).reduce((x, y) -> x + y)
					.orElseThrow(() -> new RuntimeException("An exceprion occured while processing positives"));
		}

		return result;
	}

}
