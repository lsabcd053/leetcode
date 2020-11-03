package com.lsabcd.leetcode.t78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length==0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.add(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            result.addAll(multiply(result, nums[i]));
        }
        return result;
    }

    private List<List<Integer>> multiply(List<List<Integer>> set,int n){
        List<List<Integer>> result = new ArrayList<>();
        set.forEach(i->{
            List<Integer> list = new ArrayList<>();
            list.addAll(i);
            list.add(n);
            result.add(list);
        });
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1,2,3,4}));
//        System.out.println(Math.pow(2,3));
//        System.out.println(solution.subsets(new int[]{1,2,3,4}).size());
    }
}
