package com.lsabcd.leetcode.t617;

import com.lsabcd.leetcode.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }

    private TreeNode merge(TreeNode t1, TreeNode t2){
        if (null == t1 && null == t2) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = merge(t1.left,t2.left);
        node.right = merge(t1.right, t2.right);
        return node;
    }

}
