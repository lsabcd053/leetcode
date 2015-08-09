package leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        int [] res = {0,0,0};
        
        for(int i: nums){
        	res[i]++;
        }
        for(int i=0;i<res[0];i++){
        	nums[i]=0;
        }
        for(int i=res[0];i<res[0]+res[1];i++){
        	nums[i]=1;
        }
        
        for(int i=res[0]+res[1];i<nums.length;i++){
        	nums[i]=2;
        }
    }
}
