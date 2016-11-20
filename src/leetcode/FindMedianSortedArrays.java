package leetcode;

/**
 * Created by lsabcd on 16/11/20.
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int nums1[] = {1};
        int nums2[] = {1};

        System.out.print(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1,int[]nums2){
        int m = nums1.length;
        int n = nums2.length;

        if (m==0 && n==1){
            return (double)nums2[0];
        }else if(n==0 && m==1){
            return (double)nums1[0];
        }

        int index = (m+n+(m+n)%2)/2-1;
        int i=0,j=0;
        int v1=0,v2 = 0;

        for (int t=0;t<= index+1;t++){
            v1=v2;
            if((i<m && j<n) && nums1[i] <= nums2[j]){
                v2 = nums1[i];
                i++;
            }else if((i<m && j<n) && nums1[i] >= nums2[j]){
                v2 = nums2[j];
                j++;
            }else if (i==m && j<n){
                v2 = nums2[j];
                j++;
            }else if (i<m && j==n){
                v2 = nums1[i];
                i++;
            }

        }
        if ((m+n)%2 == 1){
            return (double) v1;
        }else{
            return (double)(v1+v2)/2;
        }
    }
}
