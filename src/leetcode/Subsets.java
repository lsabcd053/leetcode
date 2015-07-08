package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String []argv){
		int[] nums={2,3,1,4,7};
		List<List<Integer>> l = subsets(nums);
		for(List<Integer> ls:l){
			for(int i:ls){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
    public static List<List<Integer>> subsets(int[] nums) {
    	if(nums.length>1)
    		quickSort(nums,0,nums.length-1);
    	int base = (int) Math.pow(2, nums.length);
    	List<List<Integer>> l = new ArrayList<List<Integer>>();
    	for(int i=0;i<=(int)(Math.pow(2, nums.length)-1);i++){
    		int tmp=i;
    		int val=0;
    		List<Integer> oneList = new ArrayList<Integer>();
    		for(int j=0;j<nums.length;j++){
    			tmp = tmp << 1;
    			val = base & tmp;
    			if(val != 0){
    				if(oneList.size()==0){
						oneList.add(0,nums[j]);
					}else if(oneList.size()==1 && oneList.get(0) > nums[j]){
						oneList.add(0,nums[j]);
					}else{
						int size = oneList.size();
						int flag=0;
						for(int inode=1;inode<size;inode++){
	    					if( oneList.get(inode) > nums[j]){
	    						oneList.add(inode-1,nums[j]);
	    						flag=1;
	    					}
	    				}
						if(flag==0){
							oneList.add(nums[j]);
						}
					}
    			}
    		}
    		l.add(oneList);
    	}
    	return l;
    }
    public static void quickSort(int[] arr, int low, int high) {  
        int i = 0, j, key = 0;  
        if (low < high) {  
            key = arr[low];  
            i = low;  
            j = high;  
            while (i < j) {  
                while (i < j && arr[j] > key)  
                    j--;  
                if (i < j)  
                    arr[i++] = arr[j];  
                while (i < j && arr[i] < key)  
                    i++;  
                if (i < j)  
                    arr[j--] = arr[i];  
            }  
        }  
        arr[i] = key;  
        if (i > low + 1)  
            quickSort(arr, low, i - 1);  
        if (i < high - 1)  
            quickSort(arr, i + 1, high);  
    } 
    public static List<List<Integer>> subsets2(int[] nums) {
        int base = (int) Math.pow(2, nums.length);
    	List<List<Integer>> l = new ArrayList<List<Integer>>();
    	for(int i=0;i<=(int)(Math.pow(2, nums.length)-1);i++){
    		int tmp=i;
    		int val=0;
    		List<Integer> oneList = new ArrayList<Integer>();
    		for(int j=0;j<nums.length;j++){
    			tmp = tmp << 1;
    			val = base & tmp;
    			if(val != 0){
    				oneList.add(nums[j]);
    			}
    		}
    		l.add(oneList);
    	}
    	return l;
    }
}
