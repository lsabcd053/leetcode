package leetcode;

import java.util.Arrays;

public class BaseTest {
	public static void main(String []argv){
		int [] a ={1,2,3,4};
		int [] b = Arrays.copyOfRange(a, 1, 2);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]+";");
		}
	}
}
