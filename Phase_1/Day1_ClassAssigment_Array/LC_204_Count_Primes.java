package Day1_ClassAssigment_Array;

public class LC_204_Count_Primes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		
		
		// prime sieve technique;
		// instead of finding prime which is less than n we find that number which is nor prime
		// like if 2 is prime the the multiple of all the 2 are never prime  
		int [] temp=new int [n+1]; // mark array (0 = prime, 1 = not prime)
		int count=0;
		temp[0]=temp[1]=1;
		for(int i=2; i*i<=n; i++) {
			if(temp[i]==0) {
				for(int j=i; j*i<n; j++) {
					temp[j*i]=1; // mark as not prime
				}
			}
		}
		
		 // count primes less than n
        for (int i = 2; i < n; i++) {
            if (temp[i] == 0) {
                count++;
            }
        }
		
          System.out.println(count);
	}

}
