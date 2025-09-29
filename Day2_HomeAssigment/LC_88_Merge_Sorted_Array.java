package Day2_HomeAssigment;

import java.util.Arrays;

public class LC_88_Merge_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1 = {1,2,3,0,0,0}; 
		int m = 3;
		int [] nums2 = {2,5,6};
		int n = 3;
		
		int i=m-1;// nums1 pointer
        int j=n-1;// nums2 pointer
        int k=m+n-1;// used for element putting in the last of nums1

        while(i>=0 && j>=0){
            if(nums1[i]<nums2[j]){
                nums1[k]=nums2[j];
                k--;
                j--;
            }
            else{
                nums1[k]=nums1[i];
                k--; 
                i--;
            }
        }
        while(j>=0){
            nums1[k]=nums2[j];
            k--;
            j--;
        }
        System.out.println(Arrays.toString(nums1));

	}

}
