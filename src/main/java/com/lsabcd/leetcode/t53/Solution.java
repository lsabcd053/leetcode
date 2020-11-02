package com.lsabcd.leetcode.t53;

public class Solution {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[][] map = new int[length][length];
        int max = map[0][0] = nums[0];
        for (int i = 1; i < length; i++) {
            map[0][i] = nums[i] + map[0][i-1];
            if (max < map[0][i]) { max = map[0][i]; }
        }
        for (int i = 1; i < length; i++) {
            map[i][i] = nums[i];
            if (max < map[i][i]) { max = map[i][i]; }
            for (int j = i+1; j < length; j++) {
                map[i][j] = map[0][j] - map[0][i] + map[i][i];
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        for (int k = 0; k < nums.length; k++) {
            System.out.printf(nums[k] + " ");
        }
        System.out.println("");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf(map[i][j] + " ");
            }
            System.out.println("");
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));

        nums = new int[]{-2,1};
        System.out.println(new Solution().maxSubArray(nums));
    }

}
