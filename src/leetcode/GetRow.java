package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
	public static void main(String []argv){
		List<Integer> l = getRow(0);
		for(int i:l){
			System.out.print(i+" ");
		}
	}
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<rowIndex;i++){
        	list.add(0,1);
        	for(int j=1;j<list.size()-1;j++){
        		list.set(j, list.get(j)+list.get(j+1));
        	}
        }
        return list;
    }
}
