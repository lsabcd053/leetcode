package com.lsabcd.leetcode.t235;

import com.lsabcd.leetcode.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = look(root,p,q);
        return result;
    }

    public TreeNode look(TreeNode root, TreeNode p, TreeNode q){
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        if (p.val > root.val && q.val > root.val) {
            return look(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return look(root.left, p, q);
        } else {
            return root;
        }
    }

    public void deepVisit(TreeNode root,TreeNode p, TreeNode q){
        if (null == root) {
            return;
        }
        System.out.print(root.val + ",");
        if (null != root.left) {
            deepVisit(root.left,p,q);
        }
        if (null != root.right) {
            deepVisit(root.right,p,q);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

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

        TreeNode result = s.lowestCommonAncestor(root,t0,t2);
        System.out.println(result.val);
    }
}
