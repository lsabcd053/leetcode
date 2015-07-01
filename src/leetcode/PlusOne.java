package leetcode;

public class PlusOne {
	public static void main(String[] argv){
		int[]num = {9,9,9,9,9,9};
		int []res = plusOne(num);
		for (int i=0;i<res.length;i++){
			System.out.print(res[i]);
		}
		
	}	
	public static int[] plusOne(int[] digits) {
		int i=digits.length-1;
		while(i>=0 && digits[i] == 9){
			digits[i]=0;
			i--;
		}
		if(i==-1 && digits[0]==0){
			int []res = new int[digits.length+1];
			for(int j=1;j<res.length;j++){
				res[j]=0;
			}
			res[0]=1;
			return res;
		}else{
			digits[i]++;
			return digits;
		}
    }
}
