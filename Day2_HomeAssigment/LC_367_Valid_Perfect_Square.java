package Day2_HomeAssigment;

public class LC_367_Valid_Perfect_Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 16;
		 System.out.println(isfound(num)) ;

	}
	public static boolean isfound(int num) {
        if (num < 2) {
            return num == 1; 
        }

        int lo = 2; 
        int hi = num / 2 + 1; 
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long) mid * mid; 
            if (square == num) {
                return true;
            } else if (square > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

}
