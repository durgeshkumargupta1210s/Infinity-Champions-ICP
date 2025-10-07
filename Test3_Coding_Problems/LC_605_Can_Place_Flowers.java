package Test3_Coding_Problems;

public class LC_605_Can_Place_Flowers {

	public static void main(String[] args) {
		// Example test case
		int []flowerbed = {1,0,0,0,1};
		int n = 1;

		// Call the function and print the result
		System.out.println(canPlaceFlowers(flowerbed, n)); // Expected output: true
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;  // Counter to track how many flowers we can plant

        // Traverse through each plot in the flowerbed
        for (int i = 0; i < flowerbed.length; i++) {

            // Check three conditions before planting:
            // 1. Left plot is empty OR current plot is at the start (i == 0)
            // 2. Right plot is empty OR current plot is at the end (i == flowerbed.length - 1)
            // 3. Current plot itself is empty (flowerbed[i] == 0)
            if ((i == 0 || flowerbed[i - 1] != 1) && 
                (i == flowerbed.length - 1 || flowerbed[i + 1] != 1) && 
                flowerbed[i] == 0) {

                // Place a flower at the current plot
                flowerbed[i] = 1;

                // Increment the count of flowers placed
                count++;
            }
        }

        // Return true if we could place at least n flowers
        return count >= n;
    }

}
