import java.util.*;

public class FirstUniqueChar {

	public static void main(String[] args) {
		System.out.println(firstUnique("leetcode"));
		System.out.println(firstUnique("leetcodelovetcdev"));
		System.out.println(firstUnique(""));
	}

	public static int firstUnique(String s) {
		if (s == null || s.length()==0) return -1;
		int[] arr = new int[26];
		for (int i=0; i<s.length(); i++) {
			arr[(int) s.charAt(i) - (int)'a']++;
		}
		for (int i=0; i<s.length(); i++) {
			if (arr[(int) s.charAt(i) - (int)'a'] == 1) return i;
		}
		return -1;
	}
}