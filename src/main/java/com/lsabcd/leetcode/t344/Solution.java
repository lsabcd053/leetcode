package com.lsabcd.leetcode.t344;

public class Solution {
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

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] cc = new char[]{};
        s.reverseString(cc);
        for (char c : cc) {
            System.out.println(c);
        }
    }
}
