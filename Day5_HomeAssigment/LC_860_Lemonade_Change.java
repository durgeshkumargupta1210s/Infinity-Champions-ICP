package Day5_HomeAssigment;

public class LC_860_Lemonade_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []bills = {5,5,5,10,20};
		
		System.out.println(lemonadeChange(bills));

	}
	
	public static boolean lemonadeChange(int[] bills) {
        int count_5 = 0;
        int count_10 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                count_5++; // received $5
            } else if (bill == 10) {
                count_10++; // received $10
                count_5--;  // give $5 as change
                if (count_5 < 0) return false; // not enough $5
            } else { // bill == 20
                // Prefer $10 + $5 first
                if (count_10 > 0 && count_5 > 0) {
                    count_10--;
                    count_5--;
                } 
                // Else, try 3 x $5
                else if (count_5 >= 3) {
                    count_5 -= 3;
                } 
                // Cannot give change
                else {
                    return false;
                }
            }
        }

        return true;
    }

}
