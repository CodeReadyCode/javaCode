package test;

public class Main2 {

	private static int count = 0;
	private static char tempChar;
	private static int tempCount = 0;

	public static void main(String[] args) {
		
		final int[] array = {4,5};
		
		array[0] = 9;
		
		array = new int[0];
		
//
//		String str = "anfnddyyyghhjiyyy";
//		char[] chars = str.toCharArray();
//
//		for (int i = 0; i < chars.length - 1; i++) {
//			// int index = i;
//			for (int j = i ; j < chars.length; j++)
//				if (chars[i] == chars[j]) {
//					count++;
//					
//				}
//			
//			if (tempCount < count) {
//				tempCount = count;
//				tempChar = chars[i];
//			}
//			count = 0;
//
//		}
//		
//		System.out.println(tempChar);
//		System.out.println(tempCount);
//		
		

	}

	public static boolean checkForUnique(String str) {
		boolean containsUnique = false;

		for (char c : str.toCharArray()) {
			if (str.indexOf(c) == str.lastIndexOf(c)) {
				containsUnique = true;
			} else {
				containsUnique = false;
			}
		}

		return containsUnique;
	}

}
