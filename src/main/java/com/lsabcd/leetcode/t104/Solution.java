package com.lsabcd.leetcode.t104;

import com.lsabcd.leetcode.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    private int depth(TreeNode root){
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(depth(root.right), depth((root.left)));
    }
}
