/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
*/

import java.lang.*;
import java.util.*;

public class MultiplyTwoStrings {
	
	public static String multiply(String s1, String s2) {
		String result = "";
		if (s1.length() == 0 || s2.length() == 0) return result;
		for (int i=s1.length()-1; i>=0; i--) {
			String base = multiply(s2, s1.charAt(i));
			String base_to_power = power(base, s1.length()-1-i);
			result = add(result, base_to_power);
		}
		return result.replaceFirst("^0+(?!$)", "");
	}

	public static String power(String s, int pow) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<pow; i++) {
			sb.append('0');
		}
		return s + sb.toString();
	}

	public static String multiply(String s1, char c) {
		if (s1.length() == 0) return "0";
		//throw a check if char is an integer
		StringBuilder sb = new StringBuilder();
		int rem = 0;
		for (int i=s1.length()-1; i>=0; i--) {
			int a = Character.getNumericValue(c);
			int b = Character.getNumericValue(s1.charAt(i));
			int t = rem + a * b;
			sb.append(Integer.toString(t % 10));
			rem = t/10;
		}
		if (rem > 0) sb.append(Integer.toString(rem));
		return sb.reverse().toString();
	}

	public static String add(String s1, String s2) {
		if (s1.length() == 0 && s2.length() == 0) return "";
		else if (s1.length() == 0) return s2;
		else if (s2.length() == 0) return s1;

		StringBuilder sb = new StringBuilder();
		int p1 = s1.length()-1, p2 = s2.length()-1;
		int rem = 0;
		while (p1 >= 0 || p2 >= 0) {
			int val = rem;
			if (p1 >=0) val += Character.getNumericValue(s1.charAt(p1--));
			if (p2 >=0) val += Character.getNumericValue(s2.charAt(p2--));
			sb.append(Integer.toString(val % 10));
			rem = val/10;
		}
		if (rem > 0) sb.append(Integer.toString(rem));
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		//test helper function
		System.out.println(add("123", "1234"));
		System.out.println(multiply("123", '9'));
		System.out.println(power("1234", 5));

		//test function
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("0", "123"));
		System.out.println(multiply("0", "0"));
		System.out.println(multiply("123", "0"));
		System.out.println(multiply("999999", "99999999999"));
	}
}