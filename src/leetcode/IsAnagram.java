package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
	public static void main(String[]argc){
		String s="char%";
		String t="char%";
		System.out.println(isAnagram(s,t));
	}
    public static  boolean isAnagram(String s, String t) {
    	int []c = new int[129];
    	int []c2 = new int[129];
    	for(char sc : s.toCharArray()){
    		c[sc]++;
    	}
    	for(char tc : t.toCharArray()){
    		c2[tc]++;
    	}
    	for(int i=0;i<c.length;i++){
    		if(c[i]!=c2[i]){
    			return false;
    		}
    	}
        return true;
    }
}
