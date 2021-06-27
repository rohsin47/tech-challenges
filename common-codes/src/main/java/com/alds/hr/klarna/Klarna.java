package com.alds.hr.klarna;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author rohsingh
 * 
 * 
1. You're given a number and you should write the multiples of 3 and 5 up to that number. Using a set is straightforward.

2. You're given a String consisting of positive integers delimited by whitespace. You must get these integers and weight sort them. 
	Sort first according to the sum of digits in each integer, if the sums are equal, the smaller one comes first. Use Java8 Comparator.comparing

3. Typical BraceChecker question. See if left parentheses match right parentheses. Use stack!  
 *
 */
public class Klarna {
      
	public static void mutipleOf3And5(int n) {
		Set<Integer> out = IntStream.range(3, n).filter(i -> (i % 3 == 0) || (i % 5 == 0)).boxed()
				.collect(Collectors.toSet());
		System.out.println(out);
	}
    
	public static void weightSorting(String in) {
		List<Integer> out = Stream.of(in.split(" ")).map(Integer::valueOf).sorted((i1, i2) -> i1.compareTo(i2))
				.collect(Collectors.toList());
		System.out.println(out);
	}
    
	public static boolean braceChecker(String in) {
		Stack<Character> s = new Stack<Character>();
		// Iterating over the entire string.
		for (char st : in.toCharArray()) {
			// If the input string contains an opening parenthesis,
			// push in on to the stack.
			if (st == '(' || st == '{' || st == '[') {
				s.push(st);
			} else {
				// In the case of valid parentheses, the stack cannot be
				// be empty if a closing parenthesis is encountered.
				if (s.empty()) {
					return false;
				}
				// If the input string contains a closing bracket,
				// then pop the corresponding opening parenthesis if present.
				char top = (Character) s.peek();
				if (st == ')' && top == '(' || st == '}' && top == '{' || st == ']' && top == '[') {
					s.pop();
				}
			}
		}
		if(!s.empty()) {
			return false;
		} 
		return true;
	}
    
	
	// 1
    private final int SIZE = 6;
    private final int NUMBER_OF_LASTCHARS_NOTTO_MASK = 4;

    /**
     *  Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most secret question is still correct.
        However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.
        Your task is to write a function maskify, which masks all but the first and last four characters with '#'.
        Non-digits should never be masked.
     */
    public String maskify(String creditCardNumber) {

        if (creditCardNumber == null || creditCardNumber.isEmpty()) {
            return "";
        }

        if (creditCardNumber.length() < SIZE) {
            return creditCardNumber;
        }

        if (creditCardNumber.replaceAll("\\D", "").length() < SIZE) {
            return creditCardNumber;
        }

        int cardLength = creditCardNumber.length();

        String inner = creditCardNumber.substring(1, cardLength - NUMBER_OF_LASTCHARS_NOTTO_MASK);
        inner = inner.replaceAll("[0-9]", "#");

        creditCardNumber = creditCardNumber.charAt(0) + inner + creditCardNumber.substring(cardLength - NUMBER_OF_LASTCHARS_NOTTO_MASK);
        return creditCardNumber;

    }
    
    
    // 2
    /**
     * Finish the function numberToOrdinal, which should take a number
        and return it as a string with the correct ordinal indicator suffix (in English).
        That is:
        numberToOrdinal(1) ==> '1st'
        numberToOrdinal(2) ==> '2nd'
        numberToOrdinal(3) ==> '3rd'
        numberToOrdinal(4) ==> '4th'
        ... and so on
        For the purposes of this challenge, you may assume that the function will always
        be passed a non-negative integer. If the function is given 0 as an argument, it should return '0' (as a string).
        To help you get started, here is an excerpt from Wikipedia's page on Ordinal Indicators:
        st is used with numbers ending in 1 (e.g. 1st, pronounced first)
        nd is used with numbers ending in 2 (e.g. 92nd, pronounced ninety-second)
        rd is used with numbers ending in 3 (e.g. 33rd, pronounced thirty-third)
        th is used for all other numbers (e.g. 9th, pronounced ninth).
        Documentation
        numberToOrdinal(number)
        Parameters:
        number: Integer
        The number to be converted to a string ordinal.
        Constraints:
        0 <= number <= 10000
        Returns: String
        Returns a string ordinal based off of the number.
     */
    private final int EDGE_CASES = 10;

    public String numberToOrdinal(Integer number) {
        String ordinal, ordinalSuffix;

        if (number.equals(0)) {
            return number.toString();
        }

        if(isEdgeCase(number)){
            ordinalSuffix = "th";
        }else{
            ordinalSuffix = determineOrdinalSuffix(number);
        }

        ordinal = number.toString();
        return ordinal.concat(ordinalSuffix);

    }

    private boolean isEdgeCase(Integer number){
        int modeToTen = number % 10;
        int modeToHundred = number % 100;
        return ((modeToHundred - modeToTen) == EDGE_CASES);
    }

    private String determineOrdinalSuffix(Integer number){
        String ordinalSuffix;
        number = number % 10;
        switch (number){
            case 1:
                ordinalSuffix = "st";
                break;
            case 2:
                ordinalSuffix = "nd";
                break;
            case 3:
                ordinalSuffix = "rd";
                break;
            default:ordinalSuffix = "th";
        }
        return ordinalSuffix;
    }
    
    
    // 3
    /**
     * 
     * /*
        Your job is to create a calculator which evaluates expressions given to you in string format.
        The expressions are numbers and operators. Go through the expression left to right, keep track of the numbers, and when
        you come to an operator, apply it to the previous two numbers, and replace them with the result.
     */
    private final List<String> operators = Stream.of(Operator.values()).map(Operator::getOp).collect(Collectors.toList());
    private Stack<Double> bucket = new Stack<>();

    public double evaluate(String expr) {
        if(expr == null || expr.isEmpty()){
            return 0.0;
        }

        Arrays.stream(expr.split(" ")).forEach(input->{
            if (operators.contains(input)) {
                Double operand2 = bucket.pop();
                Double operand1 = bucket.pop();
                Double result = Operator.valueOf(input).apply(operand1, operand2);
                bucket.push(result);
            }else{
                bucket.push(Double.parseDouble(input));
            }
        });
        return bucket.pop();
    }

    private double applyOperator(String operator, Double operand1, Double operand2){
        Double result = null;
        switch (operator){
            case "/":
                result = operand1 / operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "+":
                result = operand1 + operand2;
                break;
        }

        return result;
    }
    
    enum Operator {
        DIVIDE("/") {
        	@Override
        	public Double apply(Double op1, Double op2) {
        		return op1 / op2;
        	}
        },
        ADD("+") {
			@Override
			public Double apply(Double op1, Double op2) {
				return op1 + op2;
			}
		},
        SUBTRACT("-") {
			@Override
			public Double apply(Double op1, Double op2) {
				return op1 - op2;
			}
		},
        MUTIPLY("*") {
			@Override
			public Double apply(Double op1, Double op2) {
				return op1 * op2;
			}
		};
      
        String op;
      
        Operator(String op) {
          this.op = op;
        }
      
        public String getOp() {
          return op;
        }
        
        public abstract Double apply(Double op1, Double op2);
    }
    
    public static void main(String[] args) {
        mutipleOf3And5(20);
    }
    
}
