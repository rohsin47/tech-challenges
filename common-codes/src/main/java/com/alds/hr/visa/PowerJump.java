/**
 * 
 */
package com.alds.hr.visa;

/**
 * @author rohsi
 *
 */
public class PowerJump {
	
	public static int power(String input) {
		if (input.length() < 0) {
			return 0;
		}

		int count = 1;
		int maxJump = 0;
		Character lastJump = input.charAt(input.length() - 1);

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == lastJump) {
				if (count > maxJump) {
					maxJump = count;
				}
				count = 1;
			} else {
				count++;
			}
		}
		return maxJump;
	}

	public static void main(String[] args) {
		System.out.println("Result for 11111 : "+ power("11111"));
		System.out.println("Result for 10101 : "+ power("10101"));
	}

}
