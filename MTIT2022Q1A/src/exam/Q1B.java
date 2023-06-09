package exam;

import java.util.Arrays;

public class Q1B {
	public static void main(String[] args) {
		String[] words = { "sithum", "methmi" };
		Arrays.sort(words, Q1B::custCompare);
		Arrays.asList(words).forEach(Q1B::printList);
	}

	public static int custCompare(String a, String b) {
		return a.compareToIgnoreCase(b);
	}

	public static void printList(String word) {
		System.out.println(word);
	}
}
