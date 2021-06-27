package com.alds.hr.gs;

public class PowerOfTen {
	
	public static boolean checkPower(int input) {
		while(input > 1 && input % 10 ==0) {
			input = input / 10;
		}
		if(input == 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Power of ten : "+checkPower(2000));
	}

}
