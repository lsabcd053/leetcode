package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate {
	public static void main(String []argv){
		List<List<Integer>> l = generate2(9);
//		for(List<Integer> list : l){
//			for(Integer i : list){
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
	}
	public static List<List<Integer>> generate2(int numRows){
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	    ArrayList<Integer> row = new ArrayList<Integer>();
	    System.out.println(row.size());
	    for(int i=0;i<numRows;i++)
	    {
	        row.add(0, 1);
	        System.out.println(row.size());
	        for(int j=1;j<row.size()-1;j++){
	        	row.set(j, row.get(j)+row.get(j+1));
	        }
	        System.out.println(row.size());
	        allrows.add(new ArrayList<Integer>(row));
	    }
	    return allrows;
	}
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList();
        if(numRows==0){
        	return l;
        }
        if(numRows==1){
        	List<Integer> r1 = new ArrayList();
        	l.add(r1);
        }else if(numRows==2){
        	List<Integer> r1 = new ArrayList();
        	r1.add(1);
        	List<Integer> r2 = new ArrayList();
        	r2.add(1);
        	r2.add(1);
        	l.add(r1);
        	l.add(r2);
        }else{
        	List<Integer> r1 = new ArrayList();
        	r1.add(1);
        	List<Integer> r2 = new ArrayList();
        	r2.add(1);
        	r2.add(1);
        	l.add(r1);
        	l.add(r2);
        	for(int i=3;i<=numRows;i++){
        		List<Integer> rt = new ArrayList();
        		rt.add(1);
        		for(int j=1;j<i-1;j++){
        			rt.add(l.get(i-2).get(j)+l.get(i-2).get(j-1));
        		}
        		rt.add(1);
        		l.add(rt);
        	}
        }
        return l;
    }
}
