package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	public static void main(String[] argv){
		String s = "dvdf";
		System.out.println(lengthOfLongestSubstring2(s));
	}
    public static int lengthOfLongestSubstring(String s) {
    	int res=1;
    	
    	if(s.length() == 1){
    		return 1;
    	}
    	if(s.length() == 0){
    		return 0;
    	}
    	
    	for(int i=0;i<s.length();i++){
    		Map<Character,Character> map = new HashMap<Character, Character>();
    		map.put(s.charAt(i), s.charAt(i));
    		
    		int j=i+1;
    		char cc='\0';
    		if(j<s.length()){
    			cc = s.charAt(j);
    		}
    		while(j<s.length() && !map.containsKey(cc)){
    			map.put(cc, cc);
    			j++;
    			if(j<s.length()){
        			cc = s.charAt(j);
        		}
    		}
    		if( map.size() > res){
    			res = map.size();
    		}
    	}
        return res;
    }

	public static int lengthOfLongestSubstring2(String s) {

		int n = s.length();
		if(n < 2){
			return n;
		}
		int res = 1;
		Map<Character,Integer> map = new HashMap<Character,Integer>();

		int j=0;
		for (int i=0;i<n && i<=j;){
			char cc='\0';
			if (j<s.length()){
				cc = s.charAt(j);
			}else{
				break;
			}
			while(j< s.length() && !map.containsKey(cc = s.charAt(j))){
				map.put(cc, j);
				j++;
			}

			if(res < map.size()){
				res = map.size();
			}

			if (j<s.length()){
			    int ci = map.get(cc);
				for (int tmp=i;tmp<=ci;tmp++){
					map.remove(s.charAt(tmp));
				}
				i=ci+1;
                if (map.size() ==0){
                    map.put(s.charAt(i),i);
                }
                map.put(cc,j);
                j++;
			}else{
				break;
			}
		}

		return res;
	}
}
