package com.alds.local.recursion;

/**
 * @author rohsingh
 *
 */
public class Palindrome {

    // iterative
    public static boolean isNumberPalindrome(int n, boolean useRecursion) {
        if (useRecursion) {
            int r = reverseNumber(n, 0);
            if (r == n) {
                return true;
            }
            return false;
        }

        if (n == 0 || n == 1) {
            return true;
        }

        String s = String.valueOf(n);
        int l = s.length();
        StringBuilder r = new StringBuilder();
        while (l > 0) {
            r.append(s.charAt(l - 1));
            l--;
        }

        if (s.equals(r.toString())) {
            return true;
        }
        return false;
    }

    // recursion
    public static int reverseNumber(int n, int t) {
        if (n == 0) {
            return t;
        }
        return reverseNumber(n / 10, t * 10 + n % 10);
    }

    public static String reverseString(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("is Palindrome (12321) : " + isNumberPalindrome(12321, true));
        System.out.println("is Palindrome (12345) : " + isNumberPalindrome(12345, true));
        System.out.println("reverse number (23456) : " + reverseNumber(23456, 0));
        System.out.println("reverse string (mirror) : " + reverseString("mirror"));

    }

}
