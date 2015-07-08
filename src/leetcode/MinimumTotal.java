package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {
	public static void main(String[]argv){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer>l1 = new ArrayList<Integer>();
		l1.add(2);
		triangle.add(l1);
		
		List<Integer>l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		triangle.add(l2);
		
		List<Integer>l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		triangle.add(l3);
		
		
		List<Integer>l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		triangle.add(l4);
		
		int sum = minimumTotal(triangle);
		System.out.println(sum);
	}
    public static int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size()==0)
    		return 0;
    	if(triangle.size()==1){
    		return triangle.get(0).get(0);
    	}
        int min=0;
        int row = triangle.size();
        int [][]res = new int[triangle.size()][];
        res[0] = new int[1];
        res[0][0] = triangle.get(0).get(0);
        for(int i=1;i<row;i++){
        	List<Integer> tmpList = triangle.get(i);
        	res[i] = new int[tmpList.size()];
        	res[i][0] = res[i-1][0]+tmpList.get(0);
        	for(int j=1;j<tmpList.size()-1;j++){
        		//res[i][j] = (res[i-1][j] > res[i-1][j-1] ? res[i-1][j-1]:res[i-1][j])+tmpList.get(j);
        		res[i][j] = Math.min(res[i-1][j-1], res[i-1][j])+tmpList.get(j);
        	}
        	res[i][tmpList.size()-1] = res[i-1][i-1]+tmpList.get(tmpList.size()-1);
        }
        min = res[triangle.size()-1][0];
        for(int i=1;i<res[triangle.size()-1].length;i++){
        	if(min > res[triangle.size()-1][i])
        		min = res[triangle.size()-1][i];
        }
        return min;
    }
    
    public int minimumTotal2(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}
