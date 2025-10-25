package Day4_ClassAssigment_Sliding_Window;
import java.util.*;
public class LC_242_Valid_Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s,t));

	}
	public static boolean isAnagram(String s, String t) {

        if(t.length()!=s.length()){
            return false;
        }

        HashMap<Character, Integer> mapS=new HashMap<>();
        HashMap<Character, Integer> mapT=new HashMap<>();

        for(char ch: s.toCharArray()){
            mapS.put(ch,mapS.getOrDefault(ch,0)+1);
        }
        for(char ch: t.toCharArray()){
            mapT.put(ch,mapT.getOrDefault(ch,0)+1);
        }
        if(mapS.equals(mapT)){
            return true;
        }
        else{
            return false;
        }
        
    }

}
