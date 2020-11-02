package com.lsabcd.leetcode.t53;

public class SolutionV2 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int max = nums[0];
//        int tmp[] = new int[length];
//        tmp[0] = nums[0];
//        for (int i = 1; i < length; i++) {
//            tmp[i] = nums[i] + tmp[i-1];
//            if (max < tmp[i]) { max = tmp[i]; }
//        }
        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            if (max < sum) { max = sum; }
            for (int j = i+1; j<length; j ++) {
                sum = sum + nums[j];
                if (max < sum) { max = sum; }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new SolutionV2().maxSubArray(nums));

        nums = new int[]{-2,1};
        System.out.println(new SolutionV2().maxSubArray(nums));
    }

}
