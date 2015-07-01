package leetcode;

public class RemoveDuplicates {
	public static void main(String[] argv){
		int [] nums = {1,1,2,2,3,3,3,4};
		int c = removeDuplicates3(nums);
		printnums(nums);
	}
	public static int removeDuplicates2(int[] nums) {
		if(nums.length<2)
			return nums.length;
		
		int basei=0;
		int len = nums.length;
		
		int beforei=0;
		int before=nums[beforei];
		
		int i=1;
		for(basei=1;basei<len;){
			
			System.out.println("before:"+before+";i:"+i+";basei:"+basei);
//			boolean f=false;
			while(i < nums.length && nums[i]==before  ){
				System.out.println("while i:"+i+"basei:"+basei);
				i++;
//				f=true;
			}
			if(i==nums.length){
//				System.out.println("len:"+len);
//				len = len - (i - basei)+1;
//				System.out.println("len:"+len);
				break;
			}
			System.out.println("before2:"+before+";i:"+i+";basei:"+basei);
			before = nums[i];
			swap(nums,i,basei);
//			printnums(nums);
//			if(f){
//				len = len - (i - basei);
//			}
			
			System.out.println("len:"+len);
			i = i+1;
			basei++;
			
		}
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
	        if (i == 0 || n > nums[i-1])
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
