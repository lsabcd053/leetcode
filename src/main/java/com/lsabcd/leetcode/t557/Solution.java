package com.lsabcd.leetcode.t557;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String res = s.reverseWords("Let's  take LeetCode contest");
        System.out.printf("*"+res+"*");
    }
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String s1 : ss) {
            char[] sc = s1.toCharArray();
            reverseString(sc);
            sb.append(sc);
            sb.append(' ');
        }
        return sb.substring(0,sb.length()-1);
    }
    public void reverseString(char[] s) {
        if (null == s || s.length == 0) {
            return;
        }
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s,i,j);
            i++;
            j--;
        }
    }
    private void swap(char[] s, int i, int j) {
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}
