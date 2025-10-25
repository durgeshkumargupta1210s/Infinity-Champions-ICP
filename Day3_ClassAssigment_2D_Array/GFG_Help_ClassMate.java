package Day3_ClassAssigment_2D_Array;
import java.util.*;
public class GFG_Help_ClassMate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int arr[] = {3, 8, 5, 2, 25};
		
		Stack<Integer> st=new Stack<>();
		for(int i=0; i<n; i++) {
			
		if(st.isEmpty() || arr[i]>arr[st.peek()]) {
				st.push(i);
		}
		else {
			
			while(!st.isEmpty() && arr[i]<arr[st.peek()]) {
				arr[st.pop()]=arr[i];
			}
			st.push(i);
			
		}
			
		}
		
		while(!st.isEmpty()) {
			arr[st.pop()]=-1;
		}
		System.out.println(Arrays.toString(arr));
		
		

	}

}
