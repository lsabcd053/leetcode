package leetcode;

public class ClimbStairs {
	public int climbStairs(int n) {
		int []a = new int[n+1];
		a[1]=1;
		a[2]=2;
		if(n<3){
			return a[n];
		}
		for(int i=3;i<n+1;i++){
			a[i] = a[i-1]+a[i-2];
		}
        return a[n];
    }
}
