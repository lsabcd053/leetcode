package com.lsabcd.leetcode.t56;

public class Solution {

    public int[] singleNumbers(int[] nums) {
        int r=0;
        int res[] = {0, 0};

        for (int i = 0; i < nums.length; i++) {
            r = r ^ nums[i];
        }
        int h = 1;
        while ((r & h) == 0) {
            h <<= 1;
        }
        for (int n : nums) {
            if ((h & n) == 0) {
                res[0] = res[0] ^ n;
            } else {
                res[1] = res[1] ^ n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {3,2,1,3};
        int[] resp = new Solution().singleNumbers(nums);
        System.out.println(resp[0]+","+resp[1]);
    }

}
