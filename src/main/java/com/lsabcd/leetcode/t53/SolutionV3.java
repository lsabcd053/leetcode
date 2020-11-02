package com.lsabcd.leetcode.t53;

public class SolutionV3 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] map = new int[length*length];
        int max = map[0] = nums[0];
        for (int i = 1; i < length; i++) {
            map[i] = nums[i] + map[i-1];
            if (max < map[i]) { max = map[i]; }
        }
        for (int i = 1; i < length; i++) {
            map[i*length + i] = nums[i];
            if (max < map[i*length + i]) { max = map[i*length + i]; }
            for (int j = i+1; j < length; j++) {
                map[i*length + j] = map[j] - map[i] + map[i*length + i];
                if (max < map[i*length + j]) {
                    max = map[i*length + j];
                }
            }
        }

        for (int k = 0; k < nums.length; k++) {
            System.out.printf(nums[k] + " ");
        }
        System.out.println("");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf(map[i*length + j] + " ");
            }
//            System.out.println("");
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new SolutionV3().maxSubArray(nums));

        nums = new int[]{-2,1};
        System.out.println(new SolutionV3().maxSubArray(nums));
    }

}
