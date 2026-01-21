package week_2;
import java.util.*;
public class GFG_Reverse_Using_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S ="GeeksforGeeks";
		Stack<Character> st=new Stack<>();
        StringBuilder sb= new StringBuilder();
        for(char ch : S.toCharArray()){
            st.push(ch);
        }
        
        while(!st.isEmpty()){
            char ch=st.pop();
           sb.append(ch); 
        }
        
        System.out.println(sb.toString());

	}

}
