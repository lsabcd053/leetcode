package leetcode;

import java.util.Stack;

public class Rotate {
	public static void main(String []argv){
		int [] nu={1,2,3,4,5,6};
		for(int i=0;i<nu.length;i++){
			System.out.print(nu[i]+",");
		}
		System.out.println();
		int k=4;
		rotate3(nu,k);
		System.out.println();
		for(int i=0;i<nu.length;i++){
			System.out.print(nu[i]+",");
		}
		System.out.println();
	}
	public void rotate(int[] nums, int k) {
		
		int len = nums.length;
		if(k>len){
			k = k%len;
		}
        Stack<Integer> s = new Stack<Integer>();
        for(int i=len-1;i>=0;i--){
        	s.push(nums[i]);
        }
        for(int i=k;i<len;i++){
        	nums[i] = s.pop();
        }
        for(int i=0;i<k;i++){
        	nums[i] = s.pop();
        }
    }
	
	
public void rotate2(int[] nums, int k) {
	/*
	 * Boy, Time Limit Exceeded!
	 * */
		int len = nums.length;
		if(k>len){
			k = k%len;
		}
        int tmp=nums[len-1];
        for(int i=0;i<k;i++){
        	for(int j=len-1;j>0;j--){
        		nums[j] = nums[j-1];
        	}
        	nums[0] = tmp;
        	tmp=nums[len-1];
        }
    }

public static void rotate3(int[] nums, int k) {

	int n = nums.length;
	int nowIndex = 0;
    int tmp1, tmp2 = nums[0];
    for(int j=0,i=0; j<n; j++){
    	System.out.println(j);
        tmp1 = tmp2;
        nowIndex = (k + nowIndex) % (n);
        tmp2 = nums[nowIndex];
        nums[nowIndex] = tmp1;
        if(nowIndex == i) {
            nowIndex = ++i;
            tmp2 = nums[nowIndex];
//            System.out.println();
        }
//        System.out.print(tmp1+",");
    }
		
    }
	
}
