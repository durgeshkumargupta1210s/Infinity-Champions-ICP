package Day2_ClassAssigment;

public class LC_4_Median_of_Two_Sorted_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1 = {1,3};
		int [] nums2 = {2};
		System.out.println(findMedianSortedArrays(nums1,nums2));
		
		

	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for binary search efficiency
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int totalLength = n1 + n2;
        int halfLength = (totalLength + 1) / 2;

        int left = 0;
        int right = n1;

        while (left <= right) {
            int cut1 = (left + right) / 2;       // partition for nums1
            int cut2 = halfLength - cut1;        // partition for nums2

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Check if correct partition
            if (left1 <= right2 && left2 <= right1) {
                if (totalLength % 2 == 0) {
                    // Even total length → average of middle two
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    // Odd total length → middle element is max of left parts
                    return Math.max(left1, left2);
                }
            } 
            // Too far left in nums1 → move right
            else if (left1 > right2) {
                right = cut1 - 1;
            } 
            // Too far right in nums1 → move left
            else {
                left = cut1 + 1;
            }
        }

        // Should never reach here if input arrays are sorted
        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }

}
