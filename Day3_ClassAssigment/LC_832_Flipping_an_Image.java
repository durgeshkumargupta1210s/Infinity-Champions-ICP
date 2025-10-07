package Day3_ClassAssigment;

public class LC_832_Flipping_an_Image {

	public static void main(String[] args) {
		// Sample input matrix (image)
		int [][]image = {
			{1, 1, 0},
			{1, 0, 1},
			{0, 0, 0}
		};

		// Call the method to flip and invert the image
		flipAndInvertImage(image);
	}

	// Method to flip each row horizontally and then invert the image
	public static int[][] flipAndInvertImage(int[][] image) {
		
		// Loop through each row of the image
        for (int i = 0; i < image.length; i++) {

			// Step 1: Flip the row horizontally using two pointers
            int left = 0;                          // Start pointer
            int right = image[0].length - 1;       // End pointer

            // Swap elements from both ends moving towards the center
            while (left <= right) {
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;
                left++;
                right--;
            }

			// Step 2: Invert the flipped row (0 -> 1 and 1 -> 0)
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == 0) {
                    image[i][j] = 1;   // Invert 0 to 1
                } else {
                    image[i][j] = 0;   // Invert 1 to 0
                }
            }
        }

		// Return the transformed image
        return image;
    }
}
