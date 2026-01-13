package Day2_ClassAssigment_Binary_search;
import java.util.*;
public class LC_451_Sort_Characters_By_Frequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tree";
		// Step 1: Count frequencies
		HashMap<Character, Integer> map=new HashMap<>();
		for(char ch : s.toCharArray()) {
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		
		// Step 2: Max Heap (priority queue based on frequency)
	   PriorityQueue<Pair> pq=new PriorityQueue<>( (a, b) -> b.freq - a.freq);
	  
	   // Step 3: Insert into PQ
       for (Map.Entry<Character, Integer> entry : map.entrySet()) {
           pq.add(new Pair(entry.getValue(), entry.getKey()));
       }
       
       
       StringBuilder sb = new StringBuilder();
       while (!pq.isEmpty()) {
           Pair p = pq.poll();
           for (int i = 0; i < p.freq; i++) {
               sb.append(p.ch);
           }
       }

       System.out.println(sb.toString()); 
	 
	 
		

	}
	static class Pair{
		int freq;
		char ch;
		
		public Pair(int freq, char ch) {
			this.freq=freq;
			this.ch=ch;
		}
	}

}
