package leetcode;

public class RemoveDuplicates2 {
	public static void main(String[] argv){
		int [] nums = {1,1,1,2,2,3,3,3,4,4,5,6,7,7,8};
		int c = removeDuplicates3(nums);
		printnums(nums);
		System.out.println(c);
	}
	public static int removeDuplicates2(int[] nums) {
		if(nums.length<2)
			return nums.length;
		
		int basei=0;
		
		
        return basei;
    }
	public static void printnums(int []nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]);
		}
		System.out.println();
	}
	
	public static int removeDuplicates3(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}
	public static int removeDuplicates(int[] nums) {
		int c=0;
		int newLen=nums.length;
		int b=0;
		for(int i=0;i<newLen;){
			while(i<newLen && nums[i]==nums[b]){
				i++;
			}
			int val = i-b-1;
			for(int j=b+1;j<i;j++){
				swap(nums,nums[j],nums[j+val]);
			}
			b++;
			i=b;
			newLen = nums.length - val;
		}
        return c;
    }
	
	
	
	public static void swap(int[] nums,int a,int b){
		//System.out.println("in swap:a="+a+";b="+b);
		int temp = nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
}
