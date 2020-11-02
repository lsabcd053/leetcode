package com.lsabcd.leetcode.t78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length==0) {
            return result;
        }
        result.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j + i <= nums.length; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = j; k < j + i; k++) {
                    list.add(nums[k]);
                }
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1,2,3}));
    }
}
