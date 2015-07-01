package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] argv){
		int[] nums ={-2147483648,-2147483647,2147483647};
		summaryRanges(nums);
	}
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        
        if(nums.length==0){
        	return list;
        }
        if(nums.length == 1){
        	list.add(String.valueOf(nums[0]));
        	return list;
        }
        int b=0;
        for(int i=1;i<nums.length;i++){
        	while(i < nums.length && (nums[i]-nums[i-1]==1)){
        		i++;
        	}
        	if(b >= i-1){
        		list.add(nums[b]+"");
        	}else{
        	list.add(nums[b]+"->"+nums[i-1]);
        	}
        	b=i;
        }
        if(nums[nums.length-1]-nums[nums.length-2]!=1){
        	list.add(nums[b]+"");
        }
        for(String s:list){
        	System.out.println(s);
        }
        return list;
    }
}
