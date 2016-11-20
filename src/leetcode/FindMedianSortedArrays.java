package leetcode;

/**
 * Created by lsabcd on 16/11/20.
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int nums1[] = {1,3};
        int nums2[] = {2};

        System.out.print(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1,int[]nums2){
        int m = nums1.length;
        int n = nums2.length;

        int index = (m+n+(m+n)%2)/2;
        int i=0,j=0,count=0;
        if (nums1.length > 0){
            int cur = nums1[0];
        }

        while((i+j) < index){
            while (i<m && nums1[i] < nums2[j]){
                i++;
            }
            while(j< n && nums1[i] > nums2[j]){
                j++;
            }
        }
        return 0.0;
    }
}
