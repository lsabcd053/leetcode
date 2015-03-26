package leetcode;

public class HammingWeight {
	public static void main(String []argv){
		int n=0xF;
		n = n & (n - 1);
		System.out.println(n);
//		System.out.println(hammingWeight(n));
	}
	public static int hammingWeight(int n){
		int count=0;
		for(int i=0;i<32;i++){
			count = count + (n & 0x1);
			n = n >>> 1;
		}
		return count;
	}
}
