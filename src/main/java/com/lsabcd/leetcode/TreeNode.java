package com.lsabcd.leetcode;

public class TreeNode {
    int val;

    TreeNode left;

    TreeNode rigit;

    TreeNode(int x){val = x;}


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRigit() {
        return rigit;
    }

    public void setRigit(TreeNode rigit) {
        this.rigit = rigit;
    }

}