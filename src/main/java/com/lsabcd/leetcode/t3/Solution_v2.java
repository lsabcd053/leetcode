package com.lsabcd.leetcode.t3;

import java.util.HashMap;
import java.util.Map;

public class Solution_v2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


    public static void main(String[] args) {
        Solution_v2 solution = new Solution_v2();
        String str = "bpfbhmipx";//"aabaab!bb";
        int length = solution.lengthOfLongestSubstring(str);
        System.out.println(length);

        str = "abcabcbb";
        length = solution.lengthOfLongestSubstring(str);
        System.out.println(length);


        str = "bbbbb";
        length = solution.lengthOfLongestSubstring(str);
        System.out.println(length);

        str = "pwwkew";
        length = solution.lengthOfLongestSubstring(str);
        System.out.println(length);

        str = "abcdefacddabbbcdzxy";
        length = solution.lengthOfLongestSubstring(str);
        System.out.println(length);
        // 3 1 3 6
    }
}
