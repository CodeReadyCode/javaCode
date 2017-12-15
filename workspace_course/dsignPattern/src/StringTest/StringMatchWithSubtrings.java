package StringTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatchWithSubtrings {

	public static void main(String[] args) {

		String a = "abdcasaabdc";
		String b = "abcd";
		System.out.println(checkSubstring(a, b));

	}

	private static List<Integer> checkSubstring(String a, String b) {
		b = sortByAbcd(b);
		List<Integer> indexesOfMatchedSubStirngs = new ArrayList<>();
		for (int i = 0; i <= a.length() - b.length(); i++) {
			String part = a.substring(i, b.length() + i);
			String sortedPartStr = sortByAbcd(part);
			if (sortedPartStr.equalsIgnoreCase(b)) {
				indexesOfMatchedSubStirngs.add(i);
			}
		}
		return indexesOfMatchedSubStirngs;
	}

	private static String sortByAbcd(String b) {
		char[] chars = b.toCharArray();
		Arrays.sort(chars);
		String str = new String(chars);
		return str;
	}

}
