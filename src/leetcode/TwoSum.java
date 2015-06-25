package leetcode;

import java.util.HashMap;

public class TwoSum {
	public static void main(String []argv){
		int []n={3,2,4};
		int tar=6;
		int []res = twoSum2(n,tar);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
	public static int[] twoSum(int[] numbers, int target) {
        int []res = new int[2];
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){     	
        	hm.put(numbers[i],i);	
        }
        
        int t=0;
        for(int i=0;i<numbers.length;i++){
        	t = target - numbers[i];
        	if(hm.containsKey(t) && hm.get(t)!=i){
        			res[0] = i+1;
            		res[1] = hm.get(t)+1;
        			break;
        	}
        }
        return res;
    }
	
	
	public static int[] twoSum2(int[] numbers, int target) {
        int []res = new int[2];
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){     	
        	if(!hm.containsKey(numbers[i])){
        		hm.put(target-numbers[i], i);
        	}else{
        		res[0]=hm.get(numbers[i])+1;
        		res[1]=i+1;
        	}
        }
        return res;
    }
}
