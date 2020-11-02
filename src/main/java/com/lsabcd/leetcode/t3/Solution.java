package com.lsabcd.leetcode.t3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()==0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int s1 = 0;
        int s2 = 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 0);
        int max = 0;
        int tmp = 1;
        for (int i = 1; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer index = map.get(c);
            s2 = i;
            if (index == null) {
                map.put(c, i);
                tmp ++;
            } else {
                max = Math.max(tmp, max);
                removeItem(map,s,s1,index);
                s1 = index + 1;
                map.put(c, s2);
                tmp = s2 - s1 + 1;
            }
        }
        max = Math.max(tmp, max);
        return max;
    }
    public void removeItem(Map<Character, Integer> map,String ss,int start,int end){
        for (int i = start; i <= end ;i++) {
            map.remove(ss.charAt(i));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
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
