package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
	public static void main(String[] argv){
		
	}
	
	public int removeElement(int[] nums, int val) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			if(val != nums[i]){
				list.add(nums[i]);
			}
		}
		
		for(int i=0;i<list.size();i++){
			nums[i] = list.get(i);
		}
		
        return list.size();
    }
}
