package leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(String []argv){
		String s = "leetqcodea";
		Set<String> dict = new HashSet<String>();
		dict.add("leetq");
		dict.add("code");
		dict.add("a");
		System.out.println(wordBreak(s,dict));
	}
	public static boolean wordBreak(String s, Set<String> dict) {
		if(s.length()==0 || s==null){
			return false;
		}
		boolean[]dp = new boolean[s.length()+1];
		dp[0]  = true;
		
		for(int i=1;i<s.length()+1;i++){
			dp[i] = false;
			for(int j=0;j<i;j++){
				boolean b = dp[j] && dict.contains(s.substring(j,i));
//				System.out.println(i+":"+j);
//				System.out.println(s.substring(0,j)+":"+s.substring(j,i)+":"+b);
				if(  b  ){
					dp[i] = true;
					break;
				}
				
			}
//			System.out.println(i+"---");
//			dp[i] = t && dict.contains(s.substring(i));
//			System.out.println(i+":"+s.substring(i)+":"+dict.contains(s.substring(i)));
		}
        return dp[s.length()];
    }
}
