package leetcode;

public class ReverseBits {
	public static void main(String []argv){
		int n=0x2941E9C;
		System.out.println(Integer.toBinaryString(n));
		System.out.println("-");
		System.out.println(Integer.toBinaryString(reverseBits(n)));
	}
	public static int reverseBits(int n) {
        int res=0x0;
        int last=n & 0x1;
        if(last == 1){
        	res=0x80000000;
        }
        for(int i=0;i<32;i++){
        	last = (n>>>i) & 0x1;
        	System.out.print(last);
        	res = (res << 1)+last;
//        	n = n>>>1;
        }System.out.println("\n-");
        return res;
    }
}
