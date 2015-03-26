package leetcode;

public class NumDistinct {
	public static void main(String[]argv){
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(numDistinct( S,  T));
	}
	public static int numDistinct(String S, String T) {
		int ns = S.length();
		int nt = T.length();
		if(ns==0)
			return 0;
		if(nt==0)
			return 1;
		int [][]dp = new int[ns+1][nt+1];
		for(int i=0;i<=ns;i++){
			dp[i][0] = 1;
		}
		for(int i=1;i<=ns;i++){
//			System.out.println(i);
			for(int j=1;j<=nt;j++){
//				System.out.print(j+" ");
				if(S.charAt(i-1) == T.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
					}
				}
		}
//		System.out.println();System.out.println();System.out.println();
//		for(int i=0;i<=ns;i++){
//			for(int j=0;j<=nt;j++){
//				System.out.print(dp[i][j]+" ");
//				}
//			System.out.println();
//		}
		return dp[ns][nt];
		
    }
}
