package com.lsabcd.leetcode.t137;

public class Solution {
    public int singleNumber(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        int [] a = {2,2,2,3};

        int res = 0xFFFF;
        for (int i : a) {
            System.out.println(res);
            res = res | i;
        }

        System.out.printf( (8 | 3 | 2) + "");
    }

}
