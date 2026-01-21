package week_1;
import java.util.*;

public class LC_28_Find_the_Index_of_the_First_Occurrence_in_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String str1=sc.next();
		String str2=sc.next();
		
//		 String str1 = "sadbutsad"  ;
//		 String str2 = "sad";
		
		// Brute-Force O(M*N);
		int n=str2.length();
		for(int i=0; i<=str1.length()-n; i++) {
			String str=str1.substring(i,i+n);
			
			if(str.equals(str2)) {
				System.out.println(i);
				break;
			}
		}
		
		// using function
		
		System.out.println(str1.indexOf(str2));
	}

}
