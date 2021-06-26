package com.bfm.app;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {
	
	@Spy
	StringCalculator calc;

	@Test
	public void shouldReturnZeroForEmptyString() {
		int result = calc.add("");	
		assertThat(result, is(0));
	}
	
	@Test
	public void shouldReturnNonZeroForGivenInput() {
		String input = "1,2";
		int result = calc.add(input);	
		assertThat(result, is(3));
	}
	
	@Test
	public void shouldReturnNonZeroForNewLineInputs() {
		String input = "1\n2,3";
		int result = calc.add(input);	
		assertThat(result, is(6));
	}
	
	@Test
	public void shouldReturnNonZeroForDifferentDelimiters() {
		String input = "//;\n1;2";
		int result = calc.add(input);	
		assertThat(result, is(3));
	}
	
	@Test
	public void shouldThrowExceptionForNegativeNumbers() {
		String input = "//;\n1;2";
		int result = calc.add(input);	
		assertThat(result, is(3));
	}
	
	@Test
	public void shouldIgnoreNumberGreaterThan1000() {
		String input = "//;\n1;2;2111";
		int result = calc.add(input);	
		assertThat(result, is(3));
	}
	
	@Test
	public void shouldReturnNonZeroForMultiDelimiters() {
		String input = "//*|%\n1*2%3";
		int result = calc.add(input);	
		assertThat(result, is(6));
	}
	
	@Test
	public void shouldReturnNonZeroForManyDelimiters() {
		String input = "//***\n1***2***3";
		int result = calc.add(input);	
		assertThat(result, is(6));
	}
	
	@Test
	public void shouldReturnNonZeroForLineSeparatorDelimiters() {
		String input = "//*|%\n1*2%3";
		int result = calc.add(input);	
		assertThat(result, is(6));
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionForNegatives() {
		String input = "//*|%\n-1*-2%3";
		calc.add(input);	
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionForOneNegative() {
		String input = "//*|%\n-1*2%3";
		calc.add(input);	
	}
	
	@Test
	public void shouldReturnNonZeroForLargeSet() {
		String input = "//*|%\n1*2%3###4////67$$$$91";
		int result = calc.add(input);	
		assertThat(result, is(168));
	}
	
}
