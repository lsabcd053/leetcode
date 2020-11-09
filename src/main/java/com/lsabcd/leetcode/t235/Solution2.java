package com.lsabcd.leetcode.t235;

import com.lsabcd.leetcode.TreeNode;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }

        return root;
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        TreeNode root = new TreeNode(6);


        TreeNode t2 = new TreeNode(2);
        TreeNode t8 = new TreeNode(8);
        TreeNode t0 = new TreeNode(0);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);

        root.left = t2;root.right = t8;
        t2.left = t0;t2.right = t4;
        t8.left = t7;t8.right = t9;
        t4.left = t3;t4.right = t5;

        TreeNode result = s.lowestCommonAncestor(root,t7,t9);
        System.out.println(result.val);
    }
}
