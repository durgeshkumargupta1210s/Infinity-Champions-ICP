package Test3_Coding_Problems;

public class LC_1323_Maximum_69_Number {

	public static void main(String[] args) {
		// Input number containing only digits 6 and 9
		int num = 9669;

		// Convert the number to a String to easily modify digits
		String str = num + "";

		// Convert the string into a character array for easy in-place modification
		char[] ch = str.toCharArray();

		// Traverse through each digit from left to right
		for (int i = 0; i < ch.length; i++) {
			// Find the first occurrence of '6' and change it to '9'
			// This ensures we maximize the number by changing the most significant '6'
			if (ch[i] == '6') {
				ch[i] = '9';
				break;  // Change only the first '6' and then stop
			}
		}

		// Convert the modified character array back to a String, then to an integer
		int result = Integer.parseInt(new String(ch));

		// Print the maximum number after the change
		System.out.println(result);
	}
}
